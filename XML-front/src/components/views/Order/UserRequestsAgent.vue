<template>
 <div>
    
  <div class="container d-flex justify-content-center" style="margin-top: 20px">
    <!--Form with header-->
    <div class="card" style="width: 40%">
      <!--Header-->
      <div class="header pt-3 grey lighten-2">
         <div class="row d-flex justify-content-start">
          <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5">Requests</h3>
        </div>
      </div>
      <!--Header-->



      <div class="form-group" v-for="zahtev in zahtevi" :key="zahtev.id">
        <div class="card-body mx-8 mt-4">
          <div class="row">
            <div class="col">
              <div class="md-form">
                <label for="Form-ime">Id</label>
                <label id="Form-ime" class="form-control">{{zahtev.id}}</label>
                
              </div>
              <div class="form-group" v-for="oglas in zahtev.orderList" :key="oglas.id">
                <label for="Form-ime">AdCar id:</label>
                <label id="Form-ime" class="form-control">{{oglas.id}}</label>
                
              </div>

              <div class="md-form pb-3">
                
                <div class="text-center mb-4">
                  <button
                    type="button"
                    class="btn btn-info btn-block z-depth-2"
                  @click="accept(zahtev.id)">Accept request</button>
                </div>
                <div class="text-center mb-4">
                  <button
                    type="button"
                    class="btn btn-info btn-block z-depth-2"
                  @click="decline(zahtev.id)">Decline request</button>
                </div>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
    <!--/Form with header-->
    
  </div>
</div> 
</template>

<script>
import axios from "axios";
export default {
    data() {
    return {
      zahtevi: [],
      request: {},
    };
  },
  methods: {
    accept(id){
      console.log(id)
      axios
          .post("order/requests/"+id+"/accept")
          .then(response => {
              this.request= response.data
          })
          .catch(error => {
            console.log(error);
          });
    },
    decline(id){
      console.log(id)
      axios
          .post("order/requests/"+id+"/decline")
          .then(response => {
              this.request= response.data
          })
          .catch(error => {
            console.log(error);
          });
    },
  },
  mounted() {
    axios
      .get("/order/requests/user/" +this.$store.state.user.id)
      .then(zahtevi => {
        this.zahtevi = zahtevi.data;
      })
      .catch(error => {
        console.log(error);
      });
   }
}
</script>

<style>

</style>
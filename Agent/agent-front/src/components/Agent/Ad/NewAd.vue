<template>
     <div>
    <b-container v-if="error">
      <b-alert show variant="danger" class="d-flex justify-content-center">{{errormessage}}</b-alert>
    </b-container>

     <b-container v-if="success">
      <b-alert show variant="success" class="d-flex justify-content-center">{{successmessages}}</b-alert>
    </b-container>

    <div class="container d-flex justify-content-center" style="margin-top: 20px">
      <!--Form with header-->
      <div class="card" style="width: 60%">
        <!--Header-->
        <div class="header pt-3 grey lighten-2">
          <div class="row d-flex justify-content-start">
            <h3 class="deep-grey-text mt-3 mb-4 pb-1 mx-5" 
            style="font-size: 3rem;
            font-weight: 300;
            line-height: 1.2;
            margin-top: -12%;">Add Car</h3>
          </div>
        </div>
        <!--Header-->

        <div class="form-group">
          <div class="card-body mx-4 mt-4">
            <div v-if="newAd" class="row">
              <div class="col">
                <div class="md-form">
                  <label for="Form-carBrand">Car Brand</label>
                  <b-form-select v-model="selectedBrand">
                    <option
                      v-for="brand in brands"
                      :value="brand.id"
                      :key="brand.id"
                    >{{brand.name}}</option>
                  </b-form-select>

                  <label for="Form-phone">Car Class</label>
                  <b-form-select v-model="selectedClass">
                    <option
                      v-for="clas in classes"
                      :value="clas.id"
                      :key="clas.id"
                    >{{clas.car_class}}</option>
                  </b-form-select>

                  <label for="Form-email">Car Model</label>
                   <b-form-select v-model="selectedModel">
                    <option
                      v-for="model in models"
                      :value="model.id"
                      :key="model.id"
                    >{{model.model}}</option>
                  </b-form-select>

                  <label for="Form-adresa">City</label>
                  <input type="text" id="Form-carCity" class="form-control" v-model="form.city" />

                  <label for="Form-radnoDo">Available From</label>
                  <input type="date" id="Form-availableFrom" class="form-control" v-model="form.availableFrom" />
                   <label for="Form-radnoDo">Available To</label>
                  <input type="date" id="Form-availableTo" class="form-control" v-model="form.availableTo" />
                </div>
              </div>
              <div class="col">
                <div class="md-form pb-3">
                  <label for="Form-grad">Type of fuel</label>
                   <b-form-select v-model="selectedFuel">
                    <option
                      v-for="fuel in fuels"
                      :value="fuel.id"
                      :key="fuel.id"
                    >{{fuel.type}}</option>
                  </b-form-select>

                  <label for="Form-država">Type of gearshift</label>
                   <b-form-select v-model="selectedGear">
                    <option
                      v-for="gear in gears"
                      :value="gear.id"
                      :key="gear.id"
                    >{{gear.type}}</option>
                  </b-form-select>

                  <label for="Form-br">Kids Seats</label>
                  <input type="text" id="Form-kidsSeats" class="form-control" v-model="form.kidsSeats" />

                  <label for="Form-radnoOd">KM restricted</label>
                  <input type="text" id="Form-restriction" class="form-control" v-model="form.kmRestriction" />

                  <label for="Form-radnoOd">KM traveled</label>
                  <input type="text" id="Form-traveled" class="form-control" v-model="form.kmTraveled" />

                   <label for="Form-radnoOd">CDW</label>
                  <input type="checkbox" id="Form-cdw" class="form-control" v-model="form.cdw" />

           
                </div>
              </div>
            </div>
            <!--Body-->

            <div v-if="newAd" class="text-center mb-4">
              <br/>
              <button
                type="button"
                class="btn btn-info btn-block z-depth-2"
                @click="newCar()"
              >Add Car</button>
            </div>
          <div  v-if="changeButton" >
              <input style="display:none" ref="fileInput" type="file" @change="onFileSelected($event)"/>
              <button type="button"
                class="btn btn-info btn-block z-depth-2" @click="$refs.fileInput.click()">Choose image</button>
              <button type="button"
                class="btn btn-outline-info btn-block z-depth-2"  @click="uploadImages()">Upload Image</button>
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
        form: {
          carClass_id: {},
          carBrand_id: {},
          carModel_id: {},
          fuelType_id: {},
          gearShift_id: {},
          cdw: false,
          kidsSeats: '',
          availableFrom: '',
          availableTo: '',
          city: '',
          kmRestriction: '',
          kmTraveled: null

        },
        selectedFile: null,
        show: true,
          error: false,
      errormessage: "",
      success: false,
      successmessages: "",
      newAd: true,
      changeButton: false,
      selectedBrand: "",
       brands: [],
      selectedClass: "",
       classes: [],
      selectedModel: "",
       models: [],
      selectedFuel: "",
       fuels: [],
       selectedGear: "",
       gears: [],
       idAd: null
      
      }
    },
    methods: {
        onFileSelected(event){
            console.log(event);
            this.selectedFile = event.target.files[0];
        },
        uploadImages() {
          console.log("u uploadu" + this.idAd);
          const uploadImageData = new FormData();
          uploadImageData.append('imageFile', this.selectedFile,this.selectedFile.name);
         // var idAdCar = 5;
        axios
        .post("/images/" + this.idAd + "/Ad",uploadImageData)
        .then(form => {
          this.error = form;
          this.error = false;
           this.success = false;
            this.newAd = true;
            this.changeButton = false;
            
         
        })
        .catch(error => {
          console.log(error);
         


          
        });

          
        },
        newCar() {

            this.brands.forEach(brand => {
            if (brand.id === this.selectedBrand) {
            this.form.carBrand_id = brand;
            }
           });

           this.classes.forEach(clas => {
            if (clas.id === this.selectedClass) {
            this.form.carClass_id = clas;
            }
           });
           this.models.forEach(model => {
            if (model.id === this.selectedModel) {
            this.form.carModel_id = model;
            }
           });
           this.fuels.forEach(fuel => {
            if (fuel.id === this.selectedFuel) {
            this.form.fuelType_id = fuel;
            }
           });
           this.gears.forEach(gear => {
            if (gear.id === this.selectedGear) {
            this.form.gearShift_id = gear;
            }
           });
          
          if (this.form.carClass_id === "" || this.form.carBrand_id === "" || this.form.carModel_id === "" || this.form.fuelType_id === "" || this.form.gearShift_id === "" || this.form.kidsSeats === "" || this.form.city === "" || this.form.kmRestriction === ""){
          this.errormessage = "Please fill all fields";
          this.error = true;
          return;
        }
        var rexx = /^[a-zA-Z\-0-9\s]+$/;
        if (!rexx.test(String(this.form.city.trim()))) {
        this.errormessage = "City must not contain unacceptable characters";
        this.error = true;
        return;
      }
      var rexxx = /^[0-9\s]+$/;
        if (!rexxx.test(String(this.form.kidsSeats.trim()))) {
        this.errormessage = "Kids seats must be a number value";
        this.error = true;
        return;
      }
        if (!rexxx.test(String(this.form.kmRestriction.trim()))) {
        this.errormessage = "Km restriction must be a number value";
        this.error = true;
        return;
      }

        axios
        .post("ads/"+ this.$store.state.user.id +"/agent" , this.form)
        .then(form => {
          this.error = form,
          this.idAd = form.data.id,
          console.log(this.idAd);
          this.form.kidsSeats = "",
           this.success = true,
           this.error = false;
            this.successmessages = "You have succesfully added a new car ad. Now you can upload images for the car."
            this.changeButton = true;
            this.newAd = false;

          this.error = false;
          
        })
        .catch(error => {
          console.log(error);
          this.errormessage = "Mail vec postoji";
          this.error = true;
        });

           
        }
    },
    mounted() {
    axios
      .get("/brands")
      .then(brands => {
        this.brands = brands.data;
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .get("/models")
      .then(models => {
        this.models = models.data;
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .get("/classes")
      .then(classes => {
        this.classes = classes.data;
      })
      .catch(error => {
        console.log(error);
      });

      axios
      .get("/fuel-types")
      .then(fuels => {
        this.fuels = fuels.data;
      })
      .catch(error => {
        console.log(error);
      });

       axios
      .get("/gearshift-types")
      .then(gears => {
        this.gears = gears.data;
      })
      .catch(error => {
        console.log(error);
      });
      
  }
}
</script>

<style>

</style>
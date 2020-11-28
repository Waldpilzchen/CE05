import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios)

new Vue({
  el: '#app',
  computed: {
    // reversedMessage: function () {
    //   var x
    //   this.axios.get("localhost:8080/getAvailableHandlebarTypes").then((response) => {
    //     console.log(response.data);
    //     x = response.data;
    //   })
    //   return x;
    // },
    testText: function() {
      return "Test123Hallo";
    }
  },
  render: h => h(App)
})

var vm = new Vue({
  el: '#example',
  data: {
    message: 'Hello',
    handleBarTypes: [] = [],
    handleBarMaterials: [] = [],
    handleBarGearshifts: [] = [],
    handleBarHandleMaterials: [] = [],
    handleBarType: '',
    handleBarMaterial: '',
    handleBarGearShift: ''
  },
  beforeMount(){
    this.getAvailableHandleBarTypes();
  },
  methods: {
    fillArray: function () {
      this.retrievedBody = [
        {id: '1'},
        {id: '2'}
      ];
      this.testString = 'Test';
    },
    clearArray: function () {
      this.retrievedBody = [];
      this.testString = 'Test123';
    },
    getAvailableHandleBarTypes: function () {
      this.axios.get("http://localhost:8080/getAvailableHandlebarTypes", { crossdomain: true, headers: { 'Content-Type': null} }).then((response) => {
        console.log(response.data);
        this.handleBarTypes = response.data;
      })
    },
    getAvailableHandlebarMaterials: function (handleBarTypeParam) {
      this.handleBarTypes = [];
      this.handleBarType = handleBarTypeParam;
      var url = "http://localhost:8080/getAvailableHandlebarMaterials/" + this.handleBarType
      this.axios.post(url, {}).then( (response) => {
        console.log(response.data);
        this.handleBarMaterials = response.data;
      })
      .catch(function (error) {
        console.log(error);
      });
    },
    getAvailableHandlebarGearshifts: function (handleBarMaterialParam) {
      this.handleBarTypes = [];
      this.handleBarMaterials = [];
      this.handleBarMaterial = handleBarMaterialParam;
      var url = "http://localhost:8080/getAvailableHandlebarGearshifts/" + this.handleBarType + "/" + this.handleBarMaterial
      this.axios.post(url, {}).then( (response) => {
        console.log(response.data);
        this.handleBarGearshifts = response.data;
      })
      .catch(function (error) {
        console.log(error);
      });
    },
    getAvailableHandleMaterials: function (handleBarGearShiftParam) {
      this.handleBarTypes = [];
      this.handleBarMaterials = [];
      this.handleBarGearshifts = [];
      this.handleBarGearShift = handleBarGearShiftParam;
      var url = "http://localhost:8080/getAvailableHandleMaterials/" + this.handleBarType + "/" + this.handleBarMaterial + "/" + this.handleBarGearShift
      this.axios.post(url, {}).then( (response) => {
        console.log(response.data);
        this.handleBarHandleMaterials = response.data;
      })
      .catch(function (error) {
        console.log(error);
      });
    }
  }
})
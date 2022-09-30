const mongoose=require('mongoose');
mongoose.connect("mongodb://localhost:27017/fruitsDB", {useNewUrlParser:true});
const fruitSchema=new mongoose.Schema({ //schema making
  name:{
    type:String,
    required:[true,"Please check your data entry, no name specified!"]
  },
  rating:{
    type:Number,
    min:1,
    max:10
  },
  review:String,
});
const Fruit=mongoose.model("Fruit",fruitSchema); //adding data
// const fruit=new Fruit ({
//   name:Apple,
//   rating: 7,
//   review: "Peaches are sexy fruits."
// });
// fruit.save(); //to save the fruit data into the database
//converts singluar into prural name eg) fruit -> fruits
const personSchema=new mongoose.Schema({ //schema making
  name:String,
  age:Number,
  favfruit: fruitSchema
});

const Person=mongoose.model("Person",personSchema); //adding data
const mango=new Fruit({
  name:"Mango",
  score:9,
  review:"Decent fruit"
});
mango.save();
// const person=new Person ({
//   name:"Anshuman",
//   age:21,
//   favfruit: pineapple
// });
// person.save(); //to save the Person data into the database
Person.updateOne({name:"Anshuman"},{favfruit:mango},function(err){
  if(err){
    console.log(err);
  }else{
    console.log("Succesfully updated the document");
  }

});



Fruit.find(function(err,fruits){ //to read the data from the database
  if(err){
    console.log(err);
  }else{
    // console.log(fruits);
    mongoose.connection.close();
    fruits.forEach(function(fruit){ //to read a single property of a data
      console.log(fruit.name);

    })
  }
});

// Fruit.updateOne({_id:"632202685dcbf8559ca5bdb2"},{name:"Peach"}, function(err){
//   if(err){
//   console.log(err);
// }else{
//   console.log("Succesfully updated the document.");
// }
// });

// Fruit.deleteOne({name:"Peach"},function(err){
//   if(err){
//     console.log(err);
//   }else{
//     console.log("Succesfully deleted the document");
//   }
// });
// Person.deleteMany({name:"Anshuman Bisoyi"},function(err){
//   if(err){
//     console.log(err);
//   }else{
//     console.log("Succesfully deleted all the documents");
//   }
// });

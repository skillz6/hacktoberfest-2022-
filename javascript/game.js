var buttonColours = ["red", "blue", "green", "yellow"]; //has four colours
var gamePattern = []; //adds the random pattern in this array
var userClickedPattern=[];// stores what user clicks
var started=false; //before game starts
var level=0; //level showup

$(document).keypress(function() { //starts with a keystroke
  if (!started) {
    $("#level-title").text("Level " + level); //updates level
    nextSequence(); //calls the next random color
    started = true;
  }
});


$(".btn").click(function (){
  var userChosenColour=$(this).attr("id"); //changes id color to the user choosen color
  userClickedPattern.push(userChosenColour);
  playSound(userChosenColour); //plays the sound of the choosen color
  checkAnswer(userClickedPattern.length-1); //checks answer lenght with gamePattern lenght
});

function checkAnswer(currentLevel) {
    if (gamePattern[currentLevel] === userClickedPattern[currentLevel]) {
      console.log("success");
      if (userClickedPattern.length === gamePattern.length){
        setTimeout(function () {
          nextSequence();
        }, 1000);
      }
    } else {
      console.log("wrong");
      playSound("wrong");
      $("body").addClass("game-over");
      setTimeout(function(){
        $("body").removeClass("game-over");
      },200);
      $("#level-title").text("Game Over, Press Any Key to Restart");
      starOver();
    }
}

function nextSequence() {
  userClickedPattern = []; //to make it ready for next
  level++;
  $("#level-title").text("Level " + level);

  var randomNumber = Math.floor(Math.random() * 4);
  var randomChosenColour = buttonColours[randomNumber];
  gamePattern.push(randomChosenColour);

  $("#" + randomChosenColour).fadeIn(100).fadeOut(100).fadeIn(100);
  playSound(randomChosenColour);
}


function playSound(name) {
  var audio=new Audio("sounds/"+name+".mp3");
  audio.play();
}
function animatePress(currentColour) {
  $("#"+currentColour).addClass("pressed");
  setTimeout(function(){
    $("#"+currentColour).removeClass("pressed");
  },100);
}

function starOver() {
  level=0;
  gamePattern=[];
  started=false;
}

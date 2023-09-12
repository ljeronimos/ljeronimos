var rolesSelected = [];
let serverUrl = 'http://localhost:8080/theheist'

//CHOOSE JOB
$('.options__bank-robbery').click(function(){

    if($(this).attr('class') !== "options__bank-robbery selected"){
        $(this).addClass("selected");
    }
    else
    {
        $(this).removeClass("selected");
    }

    //SEND POST WITH JOB SELECTED
    $.ajax({
        url: serverUrl+'/api/skills',
        type: 'POST',
        data: JSON.stringify({
            title:"Bank Robbery",
        }),
        async: true,
        contentType: 'application/json',
        success: showRoles
    });

});

//If diamondRobberyJob has been pressed
$('.options__diamond-robbery').click(function(event){

    if($(this).attr('class') !== "options__diamond-robbery selected"){
        $(this).addClass("selected");
    }
    else
    {
        $(this).removeClass("selected");
    }
    
     //SEND POST WITH JOB SELECTED
     $.ajax({
        url: serverUrl+'/api/skills',
        type: 'POST',
        data: JSON.stringify({
            title:"Diamond Robbery",
        }),
        async: true,
        contentType: 'application/json',
        success: showRoles
    });

});

//If supermarket-robbery Job has been pressed
$('.options__supermarket-robbery').click(function(event){
    
    if($(this).attr('class') !== "options__supermarket-robbery selected"){
        $(this).addClass("selected");
    }
    else
    {
        $(this).removeClass("selected");
    }

    //SEND POST WITH JOB SELECTED
   
    $.ajax({
        url: serverUrl+'/api/skills',
        type: 'POST',
        data: JSON.stringify({
            title:"Supermarket Robbery",
        }),
        async: true,
        contentType: 'application/json',
        success: showRoles
    });

});

function showRoles(response){
   
    
    $('.roles').remove();

    for (let index = 0; index < response.skills.length; index++) {

        var elementStrSkills =  '<button class="roles text-uppercase" id="'+ response.skills[index] +'">'+ response.skills[index] +'</button>'
  
        var rolesoptions = $('.choose-team-roles__options');
        rolesoptions.append(elementStrSkills);
        
    }

    rolesoptions.append('<a href="#choose-team full-window"><button class="roles" id="submitRoles">OK</button></a>');
   

}

// CARD SELECTED
$(document).on('click', '.profile-card', function(){

    if($(this).attr('class') !== "profile-card h-100 text-center text-uppercase selected"){
        $(this).addClass("selected");
        console.log($(this).attr('class'));
    }
    else
    {
        $(this).removeClass("selected");
        console.log("remove");
    }

});

//POST REQUEST WAINTING FOR WORKERS
$('#submitWorkers').click(function(event){

    createAndpopulateCard();

    /*
    $.ajax({
        url: 'http://192.168.1.131:8080/theheist/api/heist',
        type: 'POST',
        data: JSON.stringify({
            title:"Bank robbery",
            skills: ["mastermind"]
        }),
        async: true,
        contentType: 'application/json',
        success: createAndpopulateCard
    });
    */

});

//If mastermind has been pressed
$('#mastermind').click(function(event){

    if($(this).attr('class') !== "role-selected"){
        $(this).addClass("role-selected");
        console.log($(this).attr('class'));
    }
    else
    {
        $(this).removeClass("role-selected");
        console.log($(this).attr('class'));
    }

});

//If distraction has been pressed
$('#distraction').click(function(event){

    if($(this).attr('class') !== "role-selected"){
        $(this).addClass("role-selected");
        console.log($(this).attr('class'));
    }
    else
    {
        $(this).removeClass("role-selected");
        console.log($(this).attr('class'));
    }

});

//If driver has been pressed
$('#drive').click(function(event){

    if($(this).attr('class') !== "role-selected"){
        $(this).addClass("role-selected");
        console.log($(this).attr('class'));
    }
    else
    {
        $(this).removeClass("role-selected");
        console.log($(this).attr('class'));
    }

});

//If diamond specialist has been pressed
$('#diamondspecialist').click(function(event){

    if($(this).attr('class') !== "role-selected"){
        $(this).addClass("-role-selected");
        console.log($(this).attr('class'));
    }
    else
    {
        $(this).removeClass("role-selected");
        console.log($(this).attr('class'));
    }

});

//If muscle has been pressed
$('#muscle').click(function(event){


    if($(this).attr('class') !== "role-selected"){
        $(this).addClass("role-selected");
        console.log($(this).attr('class'));
    }
    else
    {
        $(this).removeClass("role-selected");
        console.log($(this).attr('class'));
    }

});

//If gunner has been pressed
$('#gunner').click(function(event){

 if($(this).attr('class') !== "role-selected"){
        $(this).addClass("role-selected");
        console.log($(this).attr('class'));
    }
    else
    {
        $(this).removeClass("role-selected");
        console.log($(this).attr('class'));
    }

});

//If cleanup has been pressed
$(document).on("click", ".roles", function(){

    if($(this).attr('class') !== "roles selected"){
        $(this).addClass("selected");
        console.log($(this).attr('class'));
    }
    else
    {
        $(this).removeClass("selected");
        console.log($(this).attr('class'));
    }

});

//If submit button has been pressed
$(document).on("click", "#submitRoles", function(){

    $('.col').remove();

    console.log($('.selected'));
    
    var selected = $('.selected');

    var stringArrayRoles = [];

    for (let index = 0; index < selected.length; index++) {
       
       stringArrayRoles[index] = selected[index].id;
        
    }

    $.ajax({
        type: "POST",
        url: serverUrl+"/api/workers",
        data: JSON.stringify(stringArrayRoles),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: createAndpopulateCard,
    });
    
});

//CREATING AND POPULATING CARDS
function createAndpopulateCard(response){

    console.log(response);

    var workers = response;

    
    for (let index = 0; index < workers.length; index++) {

        var elementStr = 

        '<div class="col">' +
        '<div id="card-' + workers[index].id + '" class="profile-card h-100 text-center text-uppercase">' +
        '<div class="p-4">' +
        '<img src="/front-end/assets/card_photos/'+workers[index].alias+'.png" class="card-img-top" alt="...">' +
        '</div>' +
        '<div class="card-body">' +
        '<h3 class="card-title -' + workers[index].id + '">'+ workers[index].alias +'</h3>' +
        '<p class="card-text -'   + workers[index].id + '">'+ workers[index].skill +'</p>' +
        '<p class="card-text -'   + workers[index].id + '">'+ workers[index].rate +'€</p>' +
        '</div>' +
        '<div class="card-footer p-3">' +
        '<small id="experience -">'+ workers[index].seniority +'</small>' +
        '</div>' +
        '</div>' +
        '</div>';
    
        var cards = $('#card-section');
        cards.append(elementStr);
        
    }
   
}

$(document).on("click", ".submit-button", function(){

    window.location.href = "/front-end/html/confirmation.html";
    
});
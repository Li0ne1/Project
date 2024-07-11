let firstName = document.getElementById("firstName");
let lastName = document.getElementById("lastName");
let email = document.getElementById("email");
let message = document.getElementById("message");
let form = document.querySelector("form");

form.addEventListener("submit",(e)=>{
	const errors = [];
	
	if(firstName.value.trim()===""){
		errors.push("First name required");
	}
	
	if(lastName.value.trim()===""){
		errors.push("Last name required");
	}
	
	
	if(email.value.trim()===""){
		errors.push("Email address required");
	}
	
	if(message.value.trim()===""){
		errors.push("Message required");
	}
	
	if(firstName.value.length > 15 ) {
    	errors.push("First name cannot exceed 10 characters.");
    }

    if (lastName.value.length > 15) {
        errors.push("Last name cannot exceed 10 characters.");
    }

    if (email.value.length > 30) {
        errors.push("Email cannot exceed 20 characters.");
    }

    if (message.value.length > 200) {
        errors.push("Message cannot exceed 200 characters.");
    }
    
    if(errors.length > 0){
		e.preventDefault();
		alert(errors.join('\n'))
	}
	
})
function validatePassword() {
    const password = document.getElementById("password").value;
    const passwordError = document.getElementById("password-error");
    let isValid = true;

    if (password.length < 8) {
        isValid = false;
        passwordError.innerText = "Password must be at least 8 characters long";
    } else if (!password.match(/[A-Z]/)) {
        isValid = false;
        passwordError.innerText = "Password must contain at least one uppercase letter";
    } else if (!password.match(/[a-z]/)) {
        isValid = false;
        passwordError.innerText = "Password must contain at least one lowercase letter";
    } else if (!password.match(/[0-9]/)) {
        isValid = false;
        passwordError.innerText = "Password must contain at least one number";
    } else {
        passwordError.innerText = "";
    }

    return isValid;
}
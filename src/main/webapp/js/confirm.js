function validateForm() {
    var password = document.forms["form"]["password"].value;
    var confirm = document.forms["form"]["confirm"].value;
    if ((password !== confirm)) {
        alert("Confirm password must be the same");
        return false;
    }
}
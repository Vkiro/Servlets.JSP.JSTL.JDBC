function validateForm(form) {
    regularLogin = /^\w+$/;
    if (!regularLogin.test(form.login.value)) {
        alert("Error: Username must contain only letters, numbers and underscores!");
        form.login.focus();
        return false;
    }

    regularPassword = /.{6,}/;
    if (!regularPassword.test(form.password.value)) {
        alert("Error: Password must contain at least six characters!");
        form.password.focus();
        return false;
    }

    if (form.password.value != form.confirm.value) {
        alert("Error: Password and confirm password must be the same!");
        form.confirm.focus();
        return false;
    }
}
function validateForm(formID, Obj){

    switch(formID){
        case 'testform' :
            Obj.validate({
                rules: {
                    email: {
                        required: true,
                        email: true
                    },
                    name: {
                        required: true
                    },
                    street: {
                        required: true
                    }
                },
                messages: {
                    email: {
                        required: "Please enter an email address",
                        email: "Not a valid email address"
                    },
                    name: {
                        required: "Please enter your name"
                    },
                    street: {
                        required: "Please enter street name"
                    }
                }
            });
            return Obj.valid();
            break;

        case 'testform2' :
            Obj.validate({
                rules: {
                    email: {
                        required: true,
                        email: true
                    },
                    name: {
                        required: true
                    },
                    spouse_email: {
                        required: true,
                        email: true
                    },
                    spouse_name: {
                        required: true
                    },
                    street: {
                        required: true
                    }
                },
                messages: {
                    email: {
                        required: "Please enter an email address",
                        email: "Not a valid email address"
                    },
                    name: {
                        required: "Please enter your name"
                    },
                    spouse_email: {
                        required: "Please enter an email address",
                        email: "Not a valid email address"
                    },
                    spouse_name: {
                        required: "Please enter your spouses name"
                    },
                    street: {
                        required: "Please enter street name"
                    }
                }
            });
            return Obj.valid();
            break;
    }
}
    $(document).ready(function() {initMenu();});

$(document).ready(function() {
    $('#submit-contact').click(function(e) {
        e.preventDefault(); // Prevent the default form submission

        // Serialize the form data into JSON format
        var formData = {
            "name": $('#name').val(),
            "email": $('#email').val()
        };

        // Send the AJAX request
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/contacts/add",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function(response) {
                console.log("Contact added successfully:", response);

                // Optionally, update UI or show success message
                alert("Contact added successfully!");

                // Clear the form inputs
                $('#name').val('');
                $('#email').val('');

                // Update recent activities or reload necessary parts of the page
               
            },
            error: function(error) {
                console.error("Error adding contact:", error);
                alert("Error adding contact. Please try again.");
            }
        });
    });
});

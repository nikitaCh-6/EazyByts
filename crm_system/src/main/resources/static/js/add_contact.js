$(document).ready(function() {
    $('#add-contact-form').submit(function(event) {
        event.preventDefault(); // Prevent the default form submission

        // Collect form data
        var formData = {
            'name': $('#name').val(),
            'email': $('#email').val()
        };

        // Make AJAX POST request to add contact
        $.ajax({
            type: 'POST',
            url: '/api/contacts', // Replace with your backend endpoint for adding contacts
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                console.log('Contact added successfully:', response);
                addRecentActivity('Added new contact: ' + formData.name); // Call function to update recent activities
                $('#name').val(''); // Clear input fields after successful submission
                $('#email').val('');
            },
            error: function(xhr, status, error) {
                console.error('Error adding contact:', status, error);
            }
        });
    });

    // Function to add new recent activity dynamically
    function addRecentActivity(activity) {
        $('#recent-activities-list').prepend('<li>' + activity + '</li>');
    }
});

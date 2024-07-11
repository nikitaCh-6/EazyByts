$(document).ready(function() {
    function loadRecentActivities() {
        $.ajax({
            type: 'GET',
            url: '/api/recent-activities', // Relative URL to your backend endpoint
            success: function(data) {
                console.log('Recent activities loaded:', data);
                var activitiesList = $('#recent-activities-list');
                activitiesList.empty();
                data.forEach(function(activity) {
                    activitiesList.append('<li>' + activity.description + '</li>');
                });
            },
            error: function(xhr, status, error) {
                console.error('Error fetching recent activities:', status, error);
            }
        });
    }

    loadRecentActivities();

    function addNewActivity(description) {
        $('#recent-activities-list').prepend('<li>' + description + '</li>');
    }

    $('#add-contact-form').submit(function(event) {
        event.preventDefault();
        var formData = {
            'name': $('#name').val(),
            'email': $('#email').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/contacts', // Relative URL to your backend endpoint for adding contacts
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                console.log('Contact added successfully:', response);
                addNewActivity('Added new contact: ' + formData.name);
                $('#name').val('');
                $('#email').val('');
            },
            error: function(xhr, status, error) {
                console.error('Error adding contact:', status, error);
            }
        });
    });
});

$(function() {
    $(".update-btn").on("click", function () {
        let btn = $(this); //The button that was clicked
        let id = btn.closest("tr").find(".row-id").text();
        let status_text = btn.closest("tr").find(".row-status");
        //The rows status text

        let status_code;

        btn.html(
            '<span class="spinner-border spinner-border-sm" role="status"></span>'
        );
        //Add spinner to button

        status_text.removeClass("text-success text-danger"); //Remove status text colors
        status_text.text("......"); //Make status text ......


        btn.find("span").remove(); //Remove spinner from button
        btn.text("update"); //Re add update text to button

    });
});
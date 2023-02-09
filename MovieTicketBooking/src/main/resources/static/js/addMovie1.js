function previewFile1() {
    const preview1 = document.querySelector(".img1");
    const file1 = document.querySelector("input[type=file]").files[0];
    const reader1 = new FileReader();

    reader1.addEventListener(
        "load",
        function () {
            preview1.src = reader1.result;
        },
        false
    );

    if (file1) {
        reader1.readAsDataURL(file1);
    }
}
$(function () {
    $("#movieImage1").on("click", function () {
        $("#img1").click();
    });
})
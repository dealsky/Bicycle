$(document).ready(function () {
    countSite();
});

function countSite() {

    var colorAll = ['#16a085', '#27ae60', '#2c3e50', '#f39c12', '#e74c3c', '#9b59b6', '#FB6964', '#342224', '#472E32', '#BDBB99', '#77B1A9', '#73A857'];

    $.ajax({
        url: "/Bicycle/CountSite.do",
        type: "POST",
        dataType: "json",
        success: function (map) {
            var arr = Object.keys(map);
            var colors = [];
            var data = [], labels = [];
            for(var i = 0; i<arr.length; i++) {
                colors[i] = colorAll[i];
            }
            for(var type in map) {
                data.push(map[type]);
                labels.push(type);
            }
            var countData = {
                datasets: [{
                    data: data,
                    backgroundColor: colors
                }],
                labels: labels
            };
            var ctx = $("#countSiteChart").get(0).getContext("2d");
            var typeCountChart = new Chart(ctx, {
                type: "pie",
                data: countData
            });
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });
}
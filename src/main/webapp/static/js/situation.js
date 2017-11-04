doughnutData = {
    datasets: [{
        data: [50, 300, 100],
        backgroundColor: [
            'rgba(54, 162, 235, 1)',
            'rgba(255, 99, 132, 1)',
            'rgba(255, 205, 86, 1)'
        ]
    }],
    labels: [
        'Blue',
        'Red',
        'Yellow'
    ]
};

$(document).ready(function () {
    getBicycleCount();
});

function getBicycleCount() {

    var colorAll = ['#16a085', '#27ae60', '#2c3e50', '#f39c12', '#e74c3c', '#9b59b6', '#FB6964', '#342224', '#472E32', '#BDBB99', '#77B1A9', '#73A857'];

    $.ajax({
        url: "/Bicycle/BicycleCount.do",
        type: "POST",
        dataType: "json",
        success: function (map) {
            var arr = Object.keys(map);
            var colors = [];
            var data = [], labels = [];
            for(var i = 0; i<arr.length; i++) {
                colors[i] = colorAll[colorAll.length - i - 1];
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
            var doughnutCtx = $("#doughnutChart").get(0).getContext("2d");
            var doughnutChart = new Chart(doughnutCtx, {
                type: "doughnut",
                data: countData
            });
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });
}
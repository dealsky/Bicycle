$(document).ready(function () {

    $("#managerLoginHref").click(function () {
        login($("#managerAcc").val(), $("#managerPass").val());
    });
    countSite();
});

function login(managerAcc, managerPass) {
    if(managerAcc!=="" && managerPass!=="") {
        $.ajax({
            url: "/Bicycle/ManagerLogin.do",
            type: "POST",
            dataType: "json",
            data: {
                managerAcc: managerAcc,
                managerPass: managerPass
            },
            success: function (data) {
                if(data.errorLog === "right") {
                    window.location.href = "/Bicycle/Administer";
                } else if(data.errorLog === "pass") {
                    console.log("密码错误");
                } else {
                    console.log("无此账号");
                }
            },
            error: function (xhr) {
                console.log(xhr.responseText);
            }
        });
    } else {
        console.log("good job!")
    }
}

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
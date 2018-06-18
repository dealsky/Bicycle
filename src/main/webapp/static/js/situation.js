$(document).ready(function () {
    getBicycleTypeCount();
    getBorrowCount();
    countSite();

    var siteCount = new Vue({
        el: '.bicycle-site-count',
        data: {
            siteNum: 0,
            maxNumber: 0,
            minNumber: 0
        },
        methods: {
            ready: function() {
                $.ajax({
                    url: "/Bicycle/common/siteCount",
                    dataType: "json",
                    success: function(data){
                        siteCount.siteNum = data.siteNum;
                        siteCount.maxNumber = data.maxNumber;
                        siteCount.minNumber = data.minNumber;
                    },
                    error: function(xhr){
                        console.log(xhr.responseText);
                    }
                });
            }
        }
    });
    siteCount.ready();

    var typeCount = new Vue({
        el: '.bicycle-type-count',
        data: {
            bicNum: 0,
            maxType: {
                type: "",
                count: 0
            },
            minType: {
                type: "",
                count: 0
            }
        },
        methods: {
            ready: function() {
                $.ajax({
                    url: "/Bicycle/common/bicCount",
                    dataType: "json",
                    success: function(data){
                        typeCount.bicNum = data.bicNum;
                        typeCount.maxType = data.maxType;
                        typeCount.minType = data.minType;
                    },
                    error: function(xhr){
                        console.log(xhr.responseText);
                    }
                });
            }
        }
    });
    typeCount.ready();

    var borrowCount = new Vue({
        el: '.bicycle-borrow-count',
        data: {
            borrowSum: 0,
            maxType: {
                type: "",
                count: 0
            },
            minType: {
                type: "",
                count: 0
            }
        },
        methods: {
            ready: function() {
                $.ajax({
                    url: "/Bicycle/common/borrowCount",
                    dataType: "json",
                    success: function(data){
                        borrowCount.borrowSum = data.borrowSum;
                        borrowCount.maxType = data.maxType;
                        borrowCount.minType = data.minType;
                    },
                    error: function(xhr){
                        console.log(xhr.responseText);
                    }
                });
            }
        }
    });
    borrowCount.ready();
});

function getBicycleTypeCount() {

    var colorAll = ['#16a085', '#27ae60', '#2c3e50', '#f39c12', '#e74c3c', '#9b59b6', '#FB6964', '#342224', '#472E32', '#BDBB99', '#77B1A9', '#73A857'];

    $.ajax({
        url: "/Bicycle/common/bicycleCount",
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
            var ctx = $("#typeCountChart").get(0).getContext("2d");
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

function getBorrowCount() {

    var colorAll = ['#16a085', '#27ae60', '#2c3e50', '#f39c12', '#e74c3c', '#9b59b6', '#FB6964', '#342224', '#472E32', '#BDBB99', '#77B1A9', '#73A857'];

    $.ajax({
        url: "/Bicycle/common/bicycleBorrowCount",
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
            var borrowCountData = {
                datasets: [{
                    data: data,
                    backgroundColor: colors
                }],
                labels: labels
            };
            var ctx = $("#borrowCountChart").get(0).getContext("2d");
            var borrowCountChart = new Chart(ctx, {
                type: "pie",
                data: borrowCountData
            });
        },
        error: function (xhr) {
            console.log(xhr.responseText);
        }
    });
}

function countSite() {

    var colorAll = ['#16a085', '#27ae60', '#2c3e50', '#f39c12', '#e74c3c', '#9b59b6', '#FB6964', '#342224', '#472E32', '#BDBB99', '#77B1A9', '#73A857'];

    $.ajax({
        url: "/Bicycle/common/countSite",
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
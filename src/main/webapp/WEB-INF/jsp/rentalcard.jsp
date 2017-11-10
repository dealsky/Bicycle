
<%--
  Created by IntelliJ IDEA.
  User: boxa
  Date: 2017/10/28
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>bicycle</title>
    <jsp:include page="common/head.jsp"/>
    <link href="${pageContext.request.contextPath}/static/css/general.css" type="text/css" rel="stylesheet"/>
</head>
<body>
    <jsp:include page="common/nav.jsp"/>
    <div class="can-not-add">

    </div>

    <div class="container">
        <div class="cards">
            <script>
                function rentalClose(recId) {
                    console.log(recId);
                    $.post("/Bicycle/User/removeRentCard.do", {recId: recId}, function () {
                        window.location.href = "/Bicycle/User/RentalCard";
                    });
                }
                
                function chargeMoney(recnumber, recbalance, recid) {
                    $("#chargeMoney").modal({
                        backdrop: false,
                        show: false
                    });
                    $("#chargeMoney").on('show.bs.modal', function () {
                        $("#rentalNumber .modal-show").html(recnumber);
                        $("#rentalBalance .modal-show").html(recbalance + "元")
                        $("#rentalHidden input").val(recid);
                    });
                    $("#chargeMoney").modal("show");
                }
                $(document).ready(function () {
                    $("#moneyNum").bind("change", function () {
                        var text = $(this).val();
                        console.log("F");
                        if(text.length!==0 && text!=="0") {
                            $("#chargeBtn").attr("disabled", false);
                        } else {
                            $("#chargeBtn").attr("disabled", true);
                        }
                    });
                });

                function addRentalCard() {
                    $.ajax({
                        url: "/Bicycle/User/addRentCard.do",
                        type: "POST",
                        success: function (data) {
                            if(data.message === "right") {
                                window.location.href = "/Bicycle/User/RentalCard"
                            } else if(data.message === "error") {
                                $(".can-not-add").html("<div class=\"alert alert-warning\">\n" +
                                    "            <a href=\"#\" class=\"close\" data-dismiss=\"alert\">\n" +
                                    "                &times;\n" +
                                    "            </a>\n" +
                                    "            <strong>警告！</strong>你只能拥有一张租借卡。\n" +
                                    "        </div>");
                            } else {
                                window.location.href = "/Bicycle/User/Home";
                            }
                        },
                        error: function (xhr) {
                            console.log(xhr.responseText);
                        }
                    });
                }

            </script>
            <c:forEach items="${sessionScope.cards}" var = "card">
                <c:set var="now" value="<%=new java.util.Date()%>" />
                <div class="rental-card">
                    <div class="card-name">
                        <p>租借卡</p>
                        <div class="rental-upright">
                            <c:if test="${card.recstatus == 0}">
                                <i class="fa fa-lock fa-lg rental-lock"></i>
                            </c:if>
                            <i class="fa fa-close fa-lg rental-close" onclick="rentalClose(${card.recid})"></i>
                        </div>
                    </div>
                    <div class="card-hr">
                        <hr/>
                    </div>
                    <div class="card-message" onclick="chargeMoney(${card.recnumber}, ${card.recbalance}, ${card.recid})">
                        <p class="rental-number">卡号　${card.recnumber}</p>
                        <p class="rental-money">余额　${card.recbalance}元</p>
                        <p class="rental-time">办理时间　<fmt:formatDate type="both" value="${card.recoptime}"/></p>
                    </div>
                    <i class="fa fa-bicycle fa-5x bicycle-icon"></i>
                </div>
            </c:forEach>

            <div class="add-card">
                <a onclick="addRentalCard()"><span class="glyphicon glyphicon-plus add-icon"></span></a>
                <div class="add-card-message">
                    <p>添加租借卡</p>
                </div>
            </div>
        <div>
    </div>
            
    <!-- Modal -->
    <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" id="chargeMoney">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">充值</h4>
                </div>
                <form action="/Bicycle/User/chargeMoney.do" method="post">
                    <div class="modal-body">
                        <div id="rentalHidden">
                            <input type="hidden" name="recId"/>
                        </div>
                        <div id="rentalNumber" class="row">
                            <label class="modal-label">卡号</label>
                            <div class="modal-show"></div>
                        </div>
                        <div id="rentalBalance" class="row">
                            <label class="modal-label">余额</label>
                            <div class="modal-show"></div>
                        </div>
                        <div class="row" id="toCharge">
                            <label class="modal-label">充值金额</label>
                            <input style="margin-left: 118px;" type="number" class="form-control small-text" dir="rtl" id="moneyNum" name="recCharge"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary" disabled="disabled" id="chargeBtn">确认充值</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
</body>
</html>

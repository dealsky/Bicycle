<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="modalPass" role="dialog" aria-labelledby="modalLabelPass" aria-hidden="true">
    <div class="modal-dialog modal-pass">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="emptiePass()">&times;</button>
                <h4 class="modal-title" id="modalLabelPass">修改密码</h4>
            </div>
            <form action="" method="post">
                <div class="modal-body login-body">
                    <div class="row user-acc form-group has-feedback" id="oldPass">
                        <div class="login-label">
                            <label class="control-label">旧的密码</label>
                        </div>
                        <div class="col-md-5">
                            <input type="password" class="form-control" name="oldPass" placeholder="旧的密码"/>
                            <div class="error-if">
                            </div>
                        </div>
                    </div>
                    <div class="row user-acc form-group has-feedback" id="newPass">
                        <div class="login-label">
                            <label class="control-label">新的密码</label>
                        </div>
                        <div class="col-md-5">
                            <input type="password" class="form-control" name="newPass" placeholder="新的密码"/>
                            <div class="error-if">
                            </div>
                        </div>
                    </div>
                    <div class="row user-acc form-group has-feedback" id="passAgain">
                        <div class="login-label">
                            <label class="control-label">确认密码</label>
                        </div>
                        <div class="col-md-5">
                            <input type="password" class="form-control" name="passAgain" placeholder="确认密码"/>
                            <div class="error-if">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="error-message">
                    </div>
                    <button type="button" class="btn btn-primary" id="updatePass">确认修改</button>
                </div>
            </form>
        </div>
    </div>
</div>

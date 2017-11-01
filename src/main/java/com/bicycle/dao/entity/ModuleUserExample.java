package com.bicycle.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModuleUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModuleUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUseridIsNull() {
            addCriterion("UserId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("UserId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("UserId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("UserId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("UserId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("UserId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("UserId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("UserId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("UserId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("UserId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("UserId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("UserId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("UserName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("UserName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("UserName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("UserName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("UserName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("UserName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("UserName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("UserName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("UserName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("UserName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("UserName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("UserName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("UserName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("UserName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNull() {
            addCriterion("UserSex is null");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNotNull() {
            addCriterion("UserSex is not null");
            return (Criteria) this;
        }

        public Criteria andUsersexEqualTo(Integer value) {
            addCriterion("UserSex =", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotEqualTo(Integer value) {
            addCriterion("UserSex <>", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThan(Integer value) {
            addCriterion("UserSex >", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThanOrEqualTo(Integer value) {
            addCriterion("UserSex >=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThan(Integer value) {
            addCriterion("UserSex <", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThanOrEqualTo(Integer value) {
            addCriterion("UserSex <=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexIn(List<Integer> values) {
            addCriterion("UserSex in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotIn(List<Integer> values) {
            addCriterion("UserSex not in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexBetween(Integer value1, Integer value2) {
            addCriterion("UserSex between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotBetween(Integer value1, Integer value2) {
            addCriterion("UserSex not between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andUseraccIsNull() {
            addCriterion("UserAcc is null");
            return (Criteria) this;
        }

        public Criteria andUseraccIsNotNull() {
            addCriterion("UserAcc is not null");
            return (Criteria) this;
        }

        public Criteria andUseraccEqualTo(String value) {
            addCriterion("UserAcc =", value, "useracc");
            return (Criteria) this;
        }

        public Criteria andUseraccNotEqualTo(String value) {
            addCriterion("UserAcc <>", value, "useracc");
            return (Criteria) this;
        }

        public Criteria andUseraccGreaterThan(String value) {
            addCriterion("UserAcc >", value, "useracc");
            return (Criteria) this;
        }

        public Criteria andUseraccGreaterThanOrEqualTo(String value) {
            addCriterion("UserAcc >=", value, "useracc");
            return (Criteria) this;
        }

        public Criteria andUseraccLessThan(String value) {
            addCriterion("UserAcc <", value, "useracc");
            return (Criteria) this;
        }

        public Criteria andUseraccLessThanOrEqualTo(String value) {
            addCriterion("UserAcc <=", value, "useracc");
            return (Criteria) this;
        }

        public Criteria andUseraccLike(String value) {
            addCriterion("UserAcc like", value, "useracc");
            return (Criteria) this;
        }

        public Criteria andUseraccNotLike(String value) {
            addCriterion("UserAcc not like", value, "useracc");
            return (Criteria) this;
        }

        public Criteria andUseraccIn(List<String> values) {
            addCriterion("UserAcc in", values, "useracc");
            return (Criteria) this;
        }

        public Criteria andUseraccNotIn(List<String> values) {
            addCriterion("UserAcc not in", values, "useracc");
            return (Criteria) this;
        }

        public Criteria andUseraccBetween(String value1, String value2) {
            addCriterion("UserAcc between", value1, value2, "useracc");
            return (Criteria) this;
        }

        public Criteria andUseraccNotBetween(String value1, String value2) {
            addCriterion("UserAcc not between", value1, value2, "useracc");
            return (Criteria) this;
        }

        public Criteria andUserpassIsNull() {
            addCriterion("UserPass is null");
            return (Criteria) this;
        }

        public Criteria andUserpassIsNotNull() {
            addCriterion("UserPass is not null");
            return (Criteria) this;
        }

        public Criteria andUserpassEqualTo(String value) {
            addCriterion("UserPass =", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotEqualTo(String value) {
            addCriterion("UserPass <>", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassGreaterThan(String value) {
            addCriterion("UserPass >", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassGreaterThanOrEqualTo(String value) {
            addCriterion("UserPass >=", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassLessThan(String value) {
            addCriterion("UserPass <", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassLessThanOrEqualTo(String value) {
            addCriterion("UserPass <=", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassLike(String value) {
            addCriterion("UserPass like", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotLike(String value) {
            addCriterion("UserPass not like", value, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassIn(List<String> values) {
            addCriterion("UserPass in", values, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotIn(List<String> values) {
            addCriterion("UserPass not in", values, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassBetween(String value1, String value2) {
            addCriterion("UserPass between", value1, value2, "userpass");
            return (Criteria) this;
        }

        public Criteria andUserpassNotBetween(String value1, String value2) {
            addCriterion("UserPass not between", value1, value2, "userpass");
            return (Criteria) this;
        }

        public Criteria andUsertelIsNull() {
            addCriterion("UserTel is null");
            return (Criteria) this;
        }

        public Criteria andUsertelIsNotNull() {
            addCriterion("UserTel is not null");
            return (Criteria) this;
        }

        public Criteria andUsertelEqualTo(String value) {
            addCriterion("UserTel =", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelNotEqualTo(String value) {
            addCriterion("UserTel <>", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelGreaterThan(String value) {
            addCriterion("UserTel >", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelGreaterThanOrEqualTo(String value) {
            addCriterion("UserTel >=", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelLessThan(String value) {
            addCriterion("UserTel <", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelLessThanOrEqualTo(String value) {
            addCriterion("UserTel <=", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelLike(String value) {
            addCriterion("UserTel like", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelNotLike(String value) {
            addCriterion("UserTel not like", value, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelIn(List<String> values) {
            addCriterion("UserTel in", values, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelNotIn(List<String> values) {
            addCriterion("UserTel not in", values, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelBetween(String value1, String value2) {
            addCriterion("UserTel between", value1, value2, "usertel");
            return (Criteria) this;
        }

        public Criteria andUsertelNotBetween(String value1, String value2) {
            addCriterion("UserTel not between", value1, value2, "usertel");
            return (Criteria) this;
        }

        public Criteria andUseridcardIsNull() {
            addCriterion("UserIdCard is null");
            return (Criteria) this;
        }

        public Criteria andUseridcardIsNotNull() {
            addCriterion("UserIdCard is not null");
            return (Criteria) this;
        }

        public Criteria andUseridcardEqualTo(String value) {
            addCriterion("UserIdCard =", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardNotEqualTo(String value) {
            addCriterion("UserIdCard <>", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardGreaterThan(String value) {
            addCriterion("UserIdCard >", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardGreaterThanOrEqualTo(String value) {
            addCriterion("UserIdCard >=", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardLessThan(String value) {
            addCriterion("UserIdCard <", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardLessThanOrEqualTo(String value) {
            addCriterion("UserIdCard <=", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardLike(String value) {
            addCriterion("UserIdCard like", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardNotLike(String value) {
            addCriterion("UserIdCard not like", value, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardIn(List<String> values) {
            addCriterion("UserIdCard in", values, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardNotIn(List<String> values) {
            addCriterion("UserIdCard not in", values, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardBetween(String value1, String value2) {
            addCriterion("UserIdCard between", value1, value2, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseridcardNotBetween(String value1, String value2) {
            addCriterion("UserIdCard not between", value1, value2, "useridcard");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNull() {
            addCriterion("UserEmail is null");
            return (Criteria) this;
        }

        public Criteria andUseremailIsNotNull() {
            addCriterion("UserEmail is not null");
            return (Criteria) this;
        }

        public Criteria andUseremailEqualTo(String value) {
            addCriterion("UserEmail =", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotEqualTo(String value) {
            addCriterion("UserEmail <>", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThan(String value) {
            addCriterion("UserEmail >", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailGreaterThanOrEqualTo(String value) {
            addCriterion("UserEmail >=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThan(String value) {
            addCriterion("UserEmail <", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLessThanOrEqualTo(String value) {
            addCriterion("UserEmail <=", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailLike(String value) {
            addCriterion("UserEmail like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotLike(String value) {
            addCriterion("UserEmail not like", value, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailIn(List<String> values) {
            addCriterion("UserEmail in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotIn(List<String> values) {
            addCriterion("UserEmail not in", values, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailBetween(String value1, String value2) {
            addCriterion("UserEmail between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUseremailNotBetween(String value1, String value2) {
            addCriterion("UserEmail not between", value1, value2, "useremail");
            return (Criteria) this;
        }

        public Criteria andUserregtimeIsNull() {
            addCriterion("UserRegTime is null");
            return (Criteria) this;
        }

        public Criteria andUserregtimeIsNotNull() {
            addCriterion("UserRegTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserregtimeEqualTo(Date value) {
            addCriterion("UserRegTime =", value, "userregtime");
            return (Criteria) this;
        }

        public Criteria andUserregtimeNotEqualTo(Date value) {
            addCriterion("UserRegTime <>", value, "userregtime");
            return (Criteria) this;
        }

        public Criteria andUserregtimeGreaterThan(Date value) {
            addCriterion("UserRegTime >", value, "userregtime");
            return (Criteria) this;
        }

        public Criteria andUserregtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UserRegTime >=", value, "userregtime");
            return (Criteria) this;
        }

        public Criteria andUserregtimeLessThan(Date value) {
            addCriterion("UserRegTime <", value, "userregtime");
            return (Criteria) this;
        }

        public Criteria andUserregtimeLessThanOrEqualTo(Date value) {
            addCriterion("UserRegTime <=", value, "userregtime");
            return (Criteria) this;
        }

        public Criteria andUserregtimeIn(List<Date> values) {
            addCriterion("UserRegTime in", values, "userregtime");
            return (Criteria) this;
        }

        public Criteria andUserregtimeNotIn(List<Date> values) {
            addCriterion("UserRegTime not in", values, "userregtime");
            return (Criteria) this;
        }

        public Criteria andUserregtimeBetween(Date value1, Date value2) {
            addCriterion("UserRegTime between", value1, value2, "userregtime");
            return (Criteria) this;
        }

        public Criteria andUserregtimeNotBetween(Date value1, Date value2) {
            addCriterion("UserRegTime not between", value1, value2, "userregtime");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeIsNull() {
            addCriterion("UserLastLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeIsNotNull() {
            addCriterion("UserLastLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeEqualTo(Date value) {
            addCriterion("UserLastLoginTime =", value, "userlastlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeNotEqualTo(Date value) {
            addCriterion("UserLastLoginTime <>", value, "userlastlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeGreaterThan(Date value) {
            addCriterion("UserLastLoginTime >", value, "userlastlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UserLastLoginTime >=", value, "userlastlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeLessThan(Date value) {
            addCriterion("UserLastLoginTime <", value, "userlastlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeLessThanOrEqualTo(Date value) {
            addCriterion("UserLastLoginTime <=", value, "userlastlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeIn(List<Date> values) {
            addCriterion("UserLastLoginTime in", values, "userlastlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeNotIn(List<Date> values) {
            addCriterion("UserLastLoginTime not in", values, "userlastlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeBetween(Date value1, Date value2) {
            addCriterion("UserLastLoginTime between", value1, value2, "userlastlogintime");
            return (Criteria) this;
        }

        public Criteria andUserlastlogintimeNotBetween(Date value1, Date value2) {
            addCriterion("UserLastLoginTime not between", value1, value2, "userlastlogintime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
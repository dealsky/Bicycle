package com.bicycle.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModuleManagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModuleManagerExample() {
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

        public Criteria andMagidIsNull() {
            addCriterion("MagId is null");
            return (Criteria) this;
        }

        public Criteria andMagidIsNotNull() {
            addCriterion("MagId is not null");
            return (Criteria) this;
        }

        public Criteria andMagidEqualTo(Long value) {
            addCriterion("MagId =", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidNotEqualTo(Long value) {
            addCriterion("MagId <>", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidGreaterThan(Long value) {
            addCriterion("MagId >", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidGreaterThanOrEqualTo(Long value) {
            addCriterion("MagId >=", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidLessThan(Long value) {
            addCriterion("MagId <", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidLessThanOrEqualTo(Long value) {
            addCriterion("MagId <=", value, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidIn(List<Long> values) {
            addCriterion("MagId in", values, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidNotIn(List<Long> values) {
            addCriterion("MagId not in", values, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidBetween(Long value1, Long value2) {
            addCriterion("MagId between", value1, value2, "magid");
            return (Criteria) this;
        }

        public Criteria andMagidNotBetween(Long value1, Long value2) {
            addCriterion("MagId not between", value1, value2, "magid");
            return (Criteria) this;
        }

        public Criteria andMagnameIsNull() {
            addCriterion("MagName is null");
            return (Criteria) this;
        }

        public Criteria andMagnameIsNotNull() {
            addCriterion("MagName is not null");
            return (Criteria) this;
        }

        public Criteria andMagnameEqualTo(String value) {
            addCriterion("MagName =", value, "magname");
            return (Criteria) this;
        }

        public Criteria andMagnameNotEqualTo(String value) {
            addCriterion("MagName <>", value, "magname");
            return (Criteria) this;
        }

        public Criteria andMagnameGreaterThan(String value) {
            addCriterion("MagName >", value, "magname");
            return (Criteria) this;
        }

        public Criteria andMagnameGreaterThanOrEqualTo(String value) {
            addCriterion("MagName >=", value, "magname");
            return (Criteria) this;
        }

        public Criteria andMagnameLessThan(String value) {
            addCriterion("MagName <", value, "magname");
            return (Criteria) this;
        }

        public Criteria andMagnameLessThanOrEqualTo(String value) {
            addCriterion("MagName <=", value, "magname");
            return (Criteria) this;
        }

        public Criteria andMagnameLike(String value) {
            addCriterion("MagName like", value, "magname");
            return (Criteria) this;
        }

        public Criteria andMagnameNotLike(String value) {
            addCriterion("MagName not like", value, "magname");
            return (Criteria) this;
        }

        public Criteria andMagnameIn(List<String> values) {
            addCriterion("MagName in", values, "magname");
            return (Criteria) this;
        }

        public Criteria andMagnameNotIn(List<String> values) {
            addCriterion("MagName not in", values, "magname");
            return (Criteria) this;
        }

        public Criteria andMagnameBetween(String value1, String value2) {
            addCriterion("MagName between", value1, value2, "magname");
            return (Criteria) this;
        }

        public Criteria andMagnameNotBetween(String value1, String value2) {
            addCriterion("MagName not between", value1, value2, "magname");
            return (Criteria) this;
        }

        public Criteria andMagsexIsNull() {
            addCriterion("MagSex is null");
            return (Criteria) this;
        }

        public Criteria andMagsexIsNotNull() {
            addCriterion("MagSex is not null");
            return (Criteria) this;
        }

        public Criteria andMagsexEqualTo(Integer value) {
            addCriterion("MagSex =", value, "magsex");
            return (Criteria) this;
        }

        public Criteria andMagsexNotEqualTo(Integer value) {
            addCriterion("MagSex <>", value, "magsex");
            return (Criteria) this;
        }

        public Criteria andMagsexGreaterThan(Integer value) {
            addCriterion("MagSex >", value, "magsex");
            return (Criteria) this;
        }

        public Criteria andMagsexGreaterThanOrEqualTo(Integer value) {
            addCriterion("MagSex >=", value, "magsex");
            return (Criteria) this;
        }

        public Criteria andMagsexLessThan(Integer value) {
            addCriterion("MagSex <", value, "magsex");
            return (Criteria) this;
        }

        public Criteria andMagsexLessThanOrEqualTo(Integer value) {
            addCriterion("MagSex <=", value, "magsex");
            return (Criteria) this;
        }

        public Criteria andMagsexIn(List<Integer> values) {
            addCriterion("MagSex in", values, "magsex");
            return (Criteria) this;
        }

        public Criteria andMagsexNotIn(List<Integer> values) {
            addCriterion("MagSex not in", values, "magsex");
            return (Criteria) this;
        }

        public Criteria andMagsexBetween(Integer value1, Integer value2) {
            addCriterion("MagSex between", value1, value2, "magsex");
            return (Criteria) this;
        }

        public Criteria andMagsexNotBetween(Integer value1, Integer value2) {
            addCriterion("MagSex not between", value1, value2, "magsex");
            return (Criteria) this;
        }

        public Criteria andMagaccountIsNull() {
            addCriterion("MagAccount is null");
            return (Criteria) this;
        }

        public Criteria andMagaccountIsNotNull() {
            addCriterion("MagAccount is not null");
            return (Criteria) this;
        }

        public Criteria andMagaccountEqualTo(String value) {
            addCriterion("MagAccount =", value, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagaccountNotEqualTo(String value) {
            addCriterion("MagAccount <>", value, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagaccountGreaterThan(String value) {
            addCriterion("MagAccount >", value, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagaccountGreaterThanOrEqualTo(String value) {
            addCriterion("MagAccount >=", value, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagaccountLessThan(String value) {
            addCriterion("MagAccount <", value, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagaccountLessThanOrEqualTo(String value) {
            addCriterion("MagAccount <=", value, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagaccountLike(String value) {
            addCriterion("MagAccount like", value, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagaccountNotLike(String value) {
            addCriterion("MagAccount not like", value, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagaccountIn(List<String> values) {
            addCriterion("MagAccount in", values, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagaccountNotIn(List<String> values) {
            addCriterion("MagAccount not in", values, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagaccountBetween(String value1, String value2) {
            addCriterion("MagAccount between", value1, value2, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagaccountNotBetween(String value1, String value2) {
            addCriterion("MagAccount not between", value1, value2, "magaccount");
            return (Criteria) this;
        }

        public Criteria andMagpassIsNull() {
            addCriterion("MagPass is null");
            return (Criteria) this;
        }

        public Criteria andMagpassIsNotNull() {
            addCriterion("MagPass is not null");
            return (Criteria) this;
        }

        public Criteria andMagpassEqualTo(String value) {
            addCriterion("MagPass =", value, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagpassNotEqualTo(String value) {
            addCriterion("MagPass <>", value, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagpassGreaterThan(String value) {
            addCriterion("MagPass >", value, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagpassGreaterThanOrEqualTo(String value) {
            addCriterion("MagPass >=", value, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagpassLessThan(String value) {
            addCriterion("MagPass <", value, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagpassLessThanOrEqualTo(String value) {
            addCriterion("MagPass <=", value, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagpassLike(String value) {
            addCriterion("MagPass like", value, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagpassNotLike(String value) {
            addCriterion("MagPass not like", value, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagpassIn(List<String> values) {
            addCriterion("MagPass in", values, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagpassNotIn(List<String> values) {
            addCriterion("MagPass not in", values, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagpassBetween(String value1, String value2) {
            addCriterion("MagPass between", value1, value2, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagpassNotBetween(String value1, String value2) {
            addCriterion("MagPass not between", value1, value2, "magpass");
            return (Criteria) this;
        }

        public Criteria andMagtelIsNull() {
            addCriterion("MagTel is null");
            return (Criteria) this;
        }

        public Criteria andMagtelIsNotNull() {
            addCriterion("MagTel is not null");
            return (Criteria) this;
        }

        public Criteria andMagtelEqualTo(String value) {
            addCriterion("MagTel =", value, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagtelNotEqualTo(String value) {
            addCriterion("MagTel <>", value, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagtelGreaterThan(String value) {
            addCriterion("MagTel >", value, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagtelGreaterThanOrEqualTo(String value) {
            addCriterion("MagTel >=", value, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagtelLessThan(String value) {
            addCriterion("MagTel <", value, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagtelLessThanOrEqualTo(String value) {
            addCriterion("MagTel <=", value, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagtelLike(String value) {
            addCriterion("MagTel like", value, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagtelNotLike(String value) {
            addCriterion("MagTel not like", value, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagtelIn(List<String> values) {
            addCriterion("MagTel in", values, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagtelNotIn(List<String> values) {
            addCriterion("MagTel not in", values, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagtelBetween(String value1, String value2) {
            addCriterion("MagTel between", value1, value2, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagtelNotBetween(String value1, String value2) {
            addCriterion("MagTel not between", value1, value2, "magtel");
            return (Criteria) this;
        }

        public Criteria andMagregtimeIsNull() {
            addCriterion("MagRegTime is null");
            return (Criteria) this;
        }

        public Criteria andMagregtimeIsNotNull() {
            addCriterion("MagRegTime is not null");
            return (Criteria) this;
        }

        public Criteria andMagregtimeEqualTo(Date value) {
            addCriterion("MagRegTime =", value, "magregtime");
            return (Criteria) this;
        }

        public Criteria andMagregtimeNotEqualTo(Date value) {
            addCriterion("MagRegTime <>", value, "magregtime");
            return (Criteria) this;
        }

        public Criteria andMagregtimeGreaterThan(Date value) {
            addCriterion("MagRegTime >", value, "magregtime");
            return (Criteria) this;
        }

        public Criteria andMagregtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MagRegTime >=", value, "magregtime");
            return (Criteria) this;
        }

        public Criteria andMagregtimeLessThan(Date value) {
            addCriterion("MagRegTime <", value, "magregtime");
            return (Criteria) this;
        }

        public Criteria andMagregtimeLessThanOrEqualTo(Date value) {
            addCriterion("MagRegTime <=", value, "magregtime");
            return (Criteria) this;
        }

        public Criteria andMagregtimeIn(List<Date> values) {
            addCriterion("MagRegTime in", values, "magregtime");
            return (Criteria) this;
        }

        public Criteria andMagregtimeNotIn(List<Date> values) {
            addCriterion("MagRegTime not in", values, "magregtime");
            return (Criteria) this;
        }

        public Criteria andMagregtimeBetween(Date value1, Date value2) {
            addCriterion("MagRegTime between", value1, value2, "magregtime");
            return (Criteria) this;
        }

        public Criteria andMagregtimeNotBetween(Date value1, Date value2) {
            addCriterion("MagRegTime not between", value1, value2, "magregtime");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeIsNull() {
            addCriterion("MagLastLoginTime is null");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeIsNotNull() {
            addCriterion("MagLastLoginTime is not null");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeEqualTo(Date value) {
            addCriterion("MagLastLoginTime =", value, "maglastlogintime");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeNotEqualTo(Date value) {
            addCriterion("MagLastLoginTime <>", value, "maglastlogintime");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeGreaterThan(Date value) {
            addCriterion("MagLastLoginTime >", value, "maglastlogintime");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MagLastLoginTime >=", value, "maglastlogintime");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeLessThan(Date value) {
            addCriterion("MagLastLoginTime <", value, "maglastlogintime");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeLessThanOrEqualTo(Date value) {
            addCriterion("MagLastLoginTime <=", value, "maglastlogintime");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeIn(List<Date> values) {
            addCriterion("MagLastLoginTime in", values, "maglastlogintime");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeNotIn(List<Date> values) {
            addCriterion("MagLastLoginTime not in", values, "maglastlogintime");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeBetween(Date value1, Date value2) {
            addCriterion("MagLastLoginTime between", value1, value2, "maglastlogintime");
            return (Criteria) this;
        }

        public Criteria andMaglastlogintimeNotBetween(Date value1, Date value2) {
            addCriterion("MagLastLoginTime not between", value1, value2, "maglastlogintime");
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
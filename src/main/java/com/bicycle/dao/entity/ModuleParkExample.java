package com.bicycle.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModuleParkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModuleParkExample() {
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

        public Criteria andParkidIsNull() {
            addCriterion("ParkId is null");
            return (Criteria) this;
        }

        public Criteria andParkidIsNotNull() {
            addCriterion("ParkId is not null");
            return (Criteria) this;
        }

        public Criteria andParkidEqualTo(Long value) {
            addCriterion("ParkId =", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidNotEqualTo(Long value) {
            addCriterion("ParkId <>", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidGreaterThan(Long value) {
            addCriterion("ParkId >", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidGreaterThanOrEqualTo(Long value) {
            addCriterion("ParkId >=", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidLessThan(Long value) {
            addCriterion("ParkId <", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidLessThanOrEqualTo(Long value) {
            addCriterion("ParkId <=", value, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidIn(List<Long> values) {
            addCriterion("ParkId in", values, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidNotIn(List<Long> values) {
            addCriterion("ParkId not in", values, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidBetween(Long value1, Long value2) {
            addCriterion("ParkId between", value1, value2, "parkid");
            return (Criteria) this;
        }

        public Criteria andParkidNotBetween(Long value1, Long value2) {
            addCriterion("ParkId not between", value1, value2, "parkid");
            return (Criteria) this;
        }

        public Criteria andSiteidIsNull() {
            addCriterion("SiteId is null");
            return (Criteria) this;
        }

        public Criteria andSiteidIsNotNull() {
            addCriterion("SiteId is not null");
            return (Criteria) this;
        }

        public Criteria andSiteidEqualTo(Long value) {
            addCriterion("SiteId =", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidNotEqualTo(Long value) {
            addCriterion("SiteId <>", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidGreaterThan(Long value) {
            addCriterion("SiteId >", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidGreaterThanOrEqualTo(Long value) {
            addCriterion("SiteId >=", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidLessThan(Long value) {
            addCriterion("SiteId <", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidLessThanOrEqualTo(Long value) {
            addCriterion("SiteId <=", value, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidIn(List<Long> values) {
            addCriterion("SiteId in", values, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidNotIn(List<Long> values) {
            addCriterion("SiteId not in", values, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidBetween(Long value1, Long value2) {
            addCriterion("SiteId between", value1, value2, "siteid");
            return (Criteria) this;
        }

        public Criteria andSiteidNotBetween(Long value1, Long value2) {
            addCriterion("SiteId not between", value1, value2, "siteid");
            return (Criteria) this;
        }

        public Criteria andBicidIsNull() {
            addCriterion("BicId is null");
            return (Criteria) this;
        }

        public Criteria andBicidIsNotNull() {
            addCriterion("BicId is not null");
            return (Criteria) this;
        }

        public Criteria andBicidEqualTo(Long value) {
            addCriterion("BicId =", value, "bicid");
            return (Criteria) this;
        }

        public Criteria andBicidNotEqualTo(Long value) {
            addCriterion("BicId <>", value, "bicid");
            return (Criteria) this;
        }

        public Criteria andBicidGreaterThan(Long value) {
            addCriterion("BicId >", value, "bicid");
            return (Criteria) this;
        }

        public Criteria andBicidGreaterThanOrEqualTo(Long value) {
            addCriterion("BicId >=", value, "bicid");
            return (Criteria) this;
        }

        public Criteria andBicidLessThan(Long value) {
            addCriterion("BicId <", value, "bicid");
            return (Criteria) this;
        }

        public Criteria andBicidLessThanOrEqualTo(Long value) {
            addCriterion("BicId <=", value, "bicid");
            return (Criteria) this;
        }

        public Criteria andBicidIn(List<Long> values) {
            addCriterion("BicId in", values, "bicid");
            return (Criteria) this;
        }

        public Criteria andBicidNotIn(List<Long> values) {
            addCriterion("BicId not in", values, "bicid");
            return (Criteria) this;
        }

        public Criteria andBicidBetween(Long value1, Long value2) {
            addCriterion("BicId between", value1, value2, "bicid");
            return (Criteria) this;
        }

        public Criteria andBicidNotBetween(Long value1, Long value2) {
            addCriterion("BicId not between", value1, value2, "bicid");
            return (Criteria) this;
        }

        public Criteria andParktimeIsNull() {
            addCriterion("ParkTime is null");
            return (Criteria) this;
        }

        public Criteria andParktimeIsNotNull() {
            addCriterion("ParkTime is not null");
            return (Criteria) this;
        }

        public Criteria andParktimeEqualTo(Date value) {
            addCriterion("ParkTime =", value, "parktime");
            return (Criteria) this;
        }

        public Criteria andParktimeNotEqualTo(Date value) {
            addCriterion("ParkTime <>", value, "parktime");
            return (Criteria) this;
        }

        public Criteria andParktimeGreaterThan(Date value) {
            addCriterion("ParkTime >", value, "parktime");
            return (Criteria) this;
        }

        public Criteria andParktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ParkTime >=", value, "parktime");
            return (Criteria) this;
        }

        public Criteria andParktimeLessThan(Date value) {
            addCriterion("ParkTime <", value, "parktime");
            return (Criteria) this;
        }

        public Criteria andParktimeLessThanOrEqualTo(Date value) {
            addCriterion("ParkTime <=", value, "parktime");
            return (Criteria) this;
        }

        public Criteria andParktimeIn(List<Date> values) {
            addCriterion("ParkTime in", values, "parktime");
            return (Criteria) this;
        }

        public Criteria andParktimeNotIn(List<Date> values) {
            addCriterion("ParkTime not in", values, "parktime");
            return (Criteria) this;
        }

        public Criteria andParktimeBetween(Date value1, Date value2) {
            addCriterion("ParkTime between", value1, value2, "parktime");
            return (Criteria) this;
        }

        public Criteria andParktimeNotBetween(Date value1, Date value2) {
            addCriterion("ParkTime not between", value1, value2, "parktime");
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
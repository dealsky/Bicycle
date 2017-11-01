package com.bicycle.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModuleRentedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModuleRentedExample() {
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

        public Criteria andRentidIsNull() {
            addCriterion("RentId is null");
            return (Criteria) this;
        }

        public Criteria andRentidIsNotNull() {
            addCriterion("RentId is not null");
            return (Criteria) this;
        }

        public Criteria andRentidEqualTo(Long value) {
            addCriterion("RentId =", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidNotEqualTo(Long value) {
            addCriterion("RentId <>", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidGreaterThan(Long value) {
            addCriterion("RentId >", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidGreaterThanOrEqualTo(Long value) {
            addCriterion("RentId >=", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidLessThan(Long value) {
            addCriterion("RentId <", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidLessThanOrEqualTo(Long value) {
            addCriterion("RentId <=", value, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidIn(List<Long> values) {
            addCriterion("RentId in", values, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidNotIn(List<Long> values) {
            addCriterion("RentId not in", values, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidBetween(Long value1, Long value2) {
            addCriterion("RentId between", value1, value2, "rentid");
            return (Criteria) this;
        }

        public Criteria andRentidNotBetween(Long value1, Long value2) {
            addCriterion("RentId not between", value1, value2, "rentid");
            return (Criteria) this;
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

        public Criteria andRenttimeIsNull() {
            addCriterion("RentTime is null");
            return (Criteria) this;
        }

        public Criteria andRenttimeIsNotNull() {
            addCriterion("RentTime is not null");
            return (Criteria) this;
        }

        public Criteria andRenttimeEqualTo(Date value) {
            addCriterion("RentTime =", value, "renttime");
            return (Criteria) this;
        }

        public Criteria andRenttimeNotEqualTo(Date value) {
            addCriterion("RentTime <>", value, "renttime");
            return (Criteria) this;
        }

        public Criteria andRenttimeGreaterThan(Date value) {
            addCriterion("RentTime >", value, "renttime");
            return (Criteria) this;
        }

        public Criteria andRenttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RentTime >=", value, "renttime");
            return (Criteria) this;
        }

        public Criteria andRenttimeLessThan(Date value) {
            addCriterion("RentTime <", value, "renttime");
            return (Criteria) this;
        }

        public Criteria andRenttimeLessThanOrEqualTo(Date value) {
            addCriterion("RentTime <=", value, "renttime");
            return (Criteria) this;
        }

        public Criteria andRenttimeIn(List<Date> values) {
            addCriterion("RentTime in", values, "renttime");
            return (Criteria) this;
        }

        public Criteria andRenttimeNotIn(List<Date> values) {
            addCriterion("RentTime not in", values, "renttime");
            return (Criteria) this;
        }

        public Criteria andRenttimeBetween(Date value1, Date value2) {
            addCriterion("RentTime between", value1, value2, "renttime");
            return (Criteria) this;
        }

        public Criteria andRenttimeNotBetween(Date value1, Date value2) {
            addCriterion("RentTime not between", value1, value2, "renttime");
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
package com.bicycle.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModuleRentalcardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModuleRentalcardExample() {
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

        public Criteria andRecidIsNull() {
            addCriterion("RecId is null");
            return (Criteria) this;
        }

        public Criteria andRecidIsNotNull() {
            addCriterion("RecId is not null");
            return (Criteria) this;
        }

        public Criteria andRecidEqualTo(Long value) {
            addCriterion("RecId =", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidNotEqualTo(Long value) {
            addCriterion("RecId <>", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidGreaterThan(Long value) {
            addCriterion("RecId >", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidGreaterThanOrEqualTo(Long value) {
            addCriterion("RecId >=", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidLessThan(Long value) {
            addCriterion("RecId <", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidLessThanOrEqualTo(Long value) {
            addCriterion("RecId <=", value, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidIn(List<Long> values) {
            addCriterion("RecId in", values, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidNotIn(List<Long> values) {
            addCriterion("RecId not in", values, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidBetween(Long value1, Long value2) {
            addCriterion("RecId between", value1, value2, "recid");
            return (Criteria) this;
        }

        public Criteria andRecidNotBetween(Long value1, Long value2) {
            addCriterion("RecId not between", value1, value2, "recid");
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

        public Criteria andRecnumberIsNull() {
            addCriterion("RecNumber is null");
            return (Criteria) this;
        }

        public Criteria andRecnumberIsNotNull() {
            addCriterion("RecNumber is not null");
            return (Criteria) this;
        }

        public Criteria andRecnumberEqualTo(Long value) {
            addCriterion("RecNumber =", value, "recnumber");
            return (Criteria) this;
        }

        public Criteria andRecnumberNotEqualTo(Long value) {
            addCriterion("RecNumber <>", value, "recnumber");
            return (Criteria) this;
        }

        public Criteria andRecnumberGreaterThan(Long value) {
            addCriterion("RecNumber >", value, "recnumber");
            return (Criteria) this;
        }

        public Criteria andRecnumberGreaterThanOrEqualTo(Long value) {
            addCriterion("RecNumber >=", value, "recnumber");
            return (Criteria) this;
        }

        public Criteria andRecnumberLessThan(Long value) {
            addCriterion("RecNumber <", value, "recnumber");
            return (Criteria) this;
        }

        public Criteria andRecnumberLessThanOrEqualTo(Long value) {
            addCriterion("RecNumber <=", value, "recnumber");
            return (Criteria) this;
        }

        public Criteria andRecnumberIn(List<Long> values) {
            addCriterion("RecNumber in", values, "recnumber");
            return (Criteria) this;
        }

        public Criteria andRecnumberNotIn(List<Long> values) {
            addCriterion("RecNumber not in", values, "recnumber");
            return (Criteria) this;
        }

        public Criteria andRecnumberBetween(Long value1, Long value2) {
            addCriterion("RecNumber between", value1, value2, "recnumber");
            return (Criteria) this;
        }

        public Criteria andRecnumberNotBetween(Long value1, Long value2) {
            addCriterion("RecNumber not between", value1, value2, "recnumber");
            return (Criteria) this;
        }

        public Criteria andRecbalanceIsNull() {
            addCriterion("RecBalance is null");
            return (Criteria) this;
        }

        public Criteria andRecbalanceIsNotNull() {
            addCriterion("RecBalance is not null");
            return (Criteria) this;
        }

        public Criteria andRecbalanceEqualTo(Float value) {
            addCriterion("RecBalance =", value, "recbalance");
            return (Criteria) this;
        }

        public Criteria andRecbalanceNotEqualTo(Float value) {
            addCriterion("RecBalance <>", value, "recbalance");
            return (Criteria) this;
        }

        public Criteria andRecbalanceGreaterThan(Float value) {
            addCriterion("RecBalance >", value, "recbalance");
            return (Criteria) this;
        }

        public Criteria andRecbalanceGreaterThanOrEqualTo(Float value) {
            addCriterion("RecBalance >=", value, "recbalance");
            return (Criteria) this;
        }

        public Criteria andRecbalanceLessThan(Float value) {
            addCriterion("RecBalance <", value, "recbalance");
            return (Criteria) this;
        }

        public Criteria andRecbalanceLessThanOrEqualTo(Float value) {
            addCriterion("RecBalance <=", value, "recbalance");
            return (Criteria) this;
        }

        public Criteria andRecbalanceIn(List<Float> values) {
            addCriterion("RecBalance in", values, "recbalance");
            return (Criteria) this;
        }

        public Criteria andRecbalanceNotIn(List<Float> values) {
            addCriterion("RecBalance not in", values, "recbalance");
            return (Criteria) this;
        }

        public Criteria andRecbalanceBetween(Float value1, Float value2) {
            addCriterion("RecBalance between", value1, value2, "recbalance");
            return (Criteria) this;
        }

        public Criteria andRecbalanceNotBetween(Float value1, Float value2) {
            addCriterion("RecBalance not between", value1, value2, "recbalance");
            return (Criteria) this;
        }

        public Criteria andRecstatusIsNull() {
            addCriterion("RecStatus is null");
            return (Criteria) this;
        }

        public Criteria andRecstatusIsNotNull() {
            addCriterion("RecStatus is not null");
            return (Criteria) this;
        }

        public Criteria andRecstatusEqualTo(Integer value) {
            addCriterion("RecStatus =", value, "recstatus");
            return (Criteria) this;
        }

        public Criteria andRecstatusNotEqualTo(Integer value) {
            addCriterion("RecStatus <>", value, "recstatus");
            return (Criteria) this;
        }

        public Criteria andRecstatusGreaterThan(Integer value) {
            addCriterion("RecStatus >", value, "recstatus");
            return (Criteria) this;
        }

        public Criteria andRecstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("RecStatus >=", value, "recstatus");
            return (Criteria) this;
        }

        public Criteria andRecstatusLessThan(Integer value) {
            addCriterion("RecStatus <", value, "recstatus");
            return (Criteria) this;
        }

        public Criteria andRecstatusLessThanOrEqualTo(Integer value) {
            addCriterion("RecStatus <=", value, "recstatus");
            return (Criteria) this;
        }

        public Criteria andRecstatusIn(List<Integer> values) {
            addCriterion("RecStatus in", values, "recstatus");
            return (Criteria) this;
        }

        public Criteria andRecstatusNotIn(List<Integer> values) {
            addCriterion("RecStatus not in", values, "recstatus");
            return (Criteria) this;
        }

        public Criteria andRecstatusBetween(Integer value1, Integer value2) {
            addCriterion("RecStatus between", value1, value2, "recstatus");
            return (Criteria) this;
        }

        public Criteria andRecstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("RecStatus not between", value1, value2, "recstatus");
            return (Criteria) this;
        }

        public Criteria andRecoptimeIsNull() {
            addCriterion("RecOptime is null");
            return (Criteria) this;
        }

        public Criteria andRecoptimeIsNotNull() {
            addCriterion("RecOptime is not null");
            return (Criteria) this;
        }

        public Criteria andRecoptimeEqualTo(Date value) {
            addCriterion("RecOptime =", value, "recoptime");
            return (Criteria) this;
        }

        public Criteria andRecoptimeNotEqualTo(Date value) {
            addCriterion("RecOptime <>", value, "recoptime");
            return (Criteria) this;
        }

        public Criteria andRecoptimeGreaterThan(Date value) {
            addCriterion("RecOptime >", value, "recoptime");
            return (Criteria) this;
        }

        public Criteria andRecoptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RecOptime >=", value, "recoptime");
            return (Criteria) this;
        }

        public Criteria andRecoptimeLessThan(Date value) {
            addCriterion("RecOptime <", value, "recoptime");
            return (Criteria) this;
        }

        public Criteria andRecoptimeLessThanOrEqualTo(Date value) {
            addCriterion("RecOptime <=", value, "recoptime");
            return (Criteria) this;
        }

        public Criteria andRecoptimeIn(List<Date> values) {
            addCriterion("RecOptime in", values, "recoptime");
            return (Criteria) this;
        }

        public Criteria andRecoptimeNotIn(List<Date> values) {
            addCriterion("RecOptime not in", values, "recoptime");
            return (Criteria) this;
        }

        public Criteria andRecoptimeBetween(Date value1, Date value2) {
            addCriterion("RecOptime between", value1, value2, "recoptime");
            return (Criteria) this;
        }

        public Criteria andRecoptimeNotBetween(Date value1, Date value2) {
            addCriterion("RecOptime not between", value1, value2, "recoptime");
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
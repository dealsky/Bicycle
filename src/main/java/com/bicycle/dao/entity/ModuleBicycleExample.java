package com.bicycle.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ModuleBicycleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModuleBicycleExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andBicnumberIsNull() {
            addCriterion("BicNumber is null");
            return (Criteria) this;
        }

        public Criteria andBicnumberIsNotNull() {
            addCriterion("BicNumber is not null");
            return (Criteria) this;
        }

        public Criteria andBicnumberEqualTo(Long value) {
            addCriterion("BicNumber =", value, "bicnumber");
            return (Criteria) this;
        }

        public Criteria andBicnumberNotEqualTo(Long value) {
            addCriterion("BicNumber <>", value, "bicnumber");
            return (Criteria) this;
        }

        public Criteria andBicnumberGreaterThan(Long value) {
            addCriterion("BicNumber >", value, "bicnumber");
            return (Criteria) this;
        }

        public Criteria andBicnumberGreaterThanOrEqualTo(Long value) {
            addCriterion("BicNumber >=", value, "bicnumber");
            return (Criteria) this;
        }

        public Criteria andBicnumberLessThan(Long value) {
            addCriterion("BicNumber <", value, "bicnumber");
            return (Criteria) this;
        }

        public Criteria andBicnumberLessThanOrEqualTo(Long value) {
            addCriterion("BicNumber <=", value, "bicnumber");
            return (Criteria) this;
        }

        public Criteria andBicnumberIn(List<Long> values) {
            addCriterion("BicNumber in", values, "bicnumber");
            return (Criteria) this;
        }

        public Criteria andBicnumberNotIn(List<Long> values) {
            addCriterion("BicNumber not in", values, "bicnumber");
            return (Criteria) this;
        }

        public Criteria andBicnumberBetween(Long value1, Long value2) {
            addCriterion("BicNumber between", value1, value2, "bicnumber");
            return (Criteria) this;
        }

        public Criteria andBicnumberNotBetween(Long value1, Long value2) {
            addCriterion("BicNumber not between", value1, value2, "bicnumber");
            return (Criteria) this;
        }

        public Criteria andBictypeIsNull() {
            addCriterion("BicType is null");
            return (Criteria) this;
        }

        public Criteria andBictypeIsNotNull() {
            addCriterion("BicType is not null");
            return (Criteria) this;
        }

        public Criteria andBictypeEqualTo(String value) {
            addCriterion("BicType =", value, "bictype");
            return (Criteria) this;
        }

        public Criteria andBictypeNotEqualTo(String value) {
            addCriterion("BicType <>", value, "bictype");
            return (Criteria) this;
        }

        public Criteria andBictypeGreaterThan(String value) {
            addCriterion("BicType >", value, "bictype");
            return (Criteria) this;
        }

        public Criteria andBictypeGreaterThanOrEqualTo(String value) {
            addCriterion("BicType >=", value, "bictype");
            return (Criteria) this;
        }

        public Criteria andBictypeLessThan(String value) {
            addCriterion("BicType <", value, "bictype");
            return (Criteria) this;
        }

        public Criteria andBictypeLessThanOrEqualTo(String value) {
            addCriterion("BicType <=", value, "bictype");
            return (Criteria) this;
        }

        public Criteria andBictypeLike(String value) {
            addCriterion("BicType like", value, "bictype");
            return (Criteria) this;
        }

        public Criteria andBictypeNotLike(String value) {
            addCriterion("BicType not like", value, "bictype");
            return (Criteria) this;
        }

        public Criteria andBictypeIn(List<String> values) {
            addCriterion("BicType in", values, "bictype");
            return (Criteria) this;
        }

        public Criteria andBictypeNotIn(List<String> values) {
            addCriterion("BicType not in", values, "bictype");
            return (Criteria) this;
        }

        public Criteria andBictypeBetween(String value1, String value2) {
            addCriterion("BicType between", value1, value2, "bictype");
            return (Criteria) this;
        }

        public Criteria andBictypeNotBetween(String value1, String value2) {
            addCriterion("BicType not between", value1, value2, "bictype");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceIsNull() {
            addCriterion("BicRentPrice is null");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceIsNotNull() {
            addCriterion("BicRentPrice is not null");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceEqualTo(Float value) {
            addCriterion("BicRentPrice =", value, "bicrentprice");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceNotEqualTo(Float value) {
            addCriterion("BicRentPrice <>", value, "bicrentprice");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceGreaterThan(Float value) {
            addCriterion("BicRentPrice >", value, "bicrentprice");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceGreaterThanOrEqualTo(Float value) {
            addCriterion("BicRentPrice >=", value, "bicrentprice");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceLessThan(Float value) {
            addCriterion("BicRentPrice <", value, "bicrentprice");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceLessThanOrEqualTo(Float value) {
            addCriterion("BicRentPrice <=", value, "bicrentprice");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceIn(List<Float> values) {
            addCriterion("BicRentPrice in", values, "bicrentprice");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceNotIn(List<Float> values) {
            addCriterion("BicRentPrice not in", values, "bicrentprice");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceBetween(Float value1, Float value2) {
            addCriterion("BicRentPrice between", value1, value2, "bicrentprice");
            return (Criteria) this;
        }

        public Criteria andBicrentpriceNotBetween(Float value1, Float value2) {
            addCriterion("BicRentPrice not between", value1, value2, "bicrentprice");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeIsNull() {
            addCriterion("BicBuytime is null");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeIsNotNull() {
            addCriterion("BicBuytime is not null");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeEqualTo(Date value) {
            addCriterionForJDBCDate("BicBuytime =", value, "bicbuytime");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("BicBuytime <>", value, "bicbuytime");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("BicBuytime >", value, "bicbuytime");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BicBuytime >=", value, "bicbuytime");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeLessThan(Date value) {
            addCriterionForJDBCDate("BicBuytime <", value, "bicbuytime");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("BicBuytime <=", value, "bicbuytime");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeIn(List<Date> values) {
            addCriterionForJDBCDate("BicBuytime in", values, "bicbuytime");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("BicBuytime not in", values, "bicbuytime");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BicBuytime between", value1, value2, "bicbuytime");
            return (Criteria) this;
        }

        public Criteria andBicbuytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("BicBuytime not between", value1, value2, "bicbuytime");
            return (Criteria) this;
        }

        public Criteria andBicborrowedIsNull() {
            addCriterion("BicBorrowed is null");
            return (Criteria) this;
        }

        public Criteria andBicborrowedIsNotNull() {
            addCriterion("BicBorrowed is not null");
            return (Criteria) this;
        }

        public Criteria andBicborrowedEqualTo(Integer value) {
            addCriterion("BicBorrowed =", value, "bicborrowed");
            return (Criteria) this;
        }

        public Criteria andBicborrowedNotEqualTo(Integer value) {
            addCriterion("BicBorrowed <>", value, "bicborrowed");
            return (Criteria) this;
        }

        public Criteria andBicborrowedGreaterThan(Integer value) {
            addCriterion("BicBorrowed >", value, "bicborrowed");
            return (Criteria) this;
        }

        public Criteria andBicborrowedGreaterThanOrEqualTo(Integer value) {
            addCriterion("BicBorrowed >=", value, "bicborrowed");
            return (Criteria) this;
        }

        public Criteria andBicborrowedLessThan(Integer value) {
            addCriterion("BicBorrowed <", value, "bicborrowed");
            return (Criteria) this;
        }

        public Criteria andBicborrowedLessThanOrEqualTo(Integer value) {
            addCriterion("BicBorrowed <=", value, "bicborrowed");
            return (Criteria) this;
        }

        public Criteria andBicborrowedIn(List<Integer> values) {
            addCriterion("BicBorrowed in", values, "bicborrowed");
            return (Criteria) this;
        }

        public Criteria andBicborrowedNotIn(List<Integer> values) {
            addCriterion("BicBorrowed not in", values, "bicborrowed");
            return (Criteria) this;
        }

        public Criteria andBicborrowedBetween(Integer value1, Integer value2) {
            addCriterion("BicBorrowed between", value1, value2, "bicborrowed");
            return (Criteria) this;
        }

        public Criteria andBicborrowedNotBetween(Integer value1, Integer value2) {
            addCriterion("BicBorrowed not between", value1, value2, "bicborrowed");
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
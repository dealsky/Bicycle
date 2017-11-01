package com.bicycle.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class ModuleSiteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModuleSiteExample() {
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

        public Criteria andSitenumberIsNull() {
            addCriterion("SiteNumber is null");
            return (Criteria) this;
        }

        public Criteria andSitenumberIsNotNull() {
            addCriterion("SiteNumber is not null");
            return (Criteria) this;
        }

        public Criteria andSitenumberEqualTo(Long value) {
            addCriterion("SiteNumber =", value, "sitenumber");
            return (Criteria) this;
        }

        public Criteria andSitenumberNotEqualTo(Long value) {
            addCriterion("SiteNumber <>", value, "sitenumber");
            return (Criteria) this;
        }

        public Criteria andSitenumberGreaterThan(Long value) {
            addCriterion("SiteNumber >", value, "sitenumber");
            return (Criteria) this;
        }

        public Criteria andSitenumberGreaterThanOrEqualTo(Long value) {
            addCriterion("SiteNumber >=", value, "sitenumber");
            return (Criteria) this;
        }

        public Criteria andSitenumberLessThan(Long value) {
            addCriterion("SiteNumber <", value, "sitenumber");
            return (Criteria) this;
        }

        public Criteria andSitenumberLessThanOrEqualTo(Long value) {
            addCriterion("SiteNumber <=", value, "sitenumber");
            return (Criteria) this;
        }

        public Criteria andSitenumberIn(List<Long> values) {
            addCriterion("SiteNumber in", values, "sitenumber");
            return (Criteria) this;
        }

        public Criteria andSitenumberNotIn(List<Long> values) {
            addCriterion("SiteNumber not in", values, "sitenumber");
            return (Criteria) this;
        }

        public Criteria andSitenumberBetween(Long value1, Long value2) {
            addCriterion("SiteNumber between", value1, value2, "sitenumber");
            return (Criteria) this;
        }

        public Criteria andSitenumberNotBetween(Long value1, Long value2) {
            addCriterion("SiteNumber not between", value1, value2, "sitenumber");
            return (Criteria) this;
        }

        public Criteria andSiteareaIsNull() {
            addCriterion("SiteArea is null");
            return (Criteria) this;
        }

        public Criteria andSiteareaIsNotNull() {
            addCriterion("SiteArea is not null");
            return (Criteria) this;
        }

        public Criteria andSiteareaEqualTo(String value) {
            addCriterion("SiteArea =", value, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteareaNotEqualTo(String value) {
            addCriterion("SiteArea <>", value, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteareaGreaterThan(String value) {
            addCriterion("SiteArea >", value, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteareaGreaterThanOrEqualTo(String value) {
            addCriterion("SiteArea >=", value, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteareaLessThan(String value) {
            addCriterion("SiteArea <", value, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteareaLessThanOrEqualTo(String value) {
            addCriterion("SiteArea <=", value, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteareaLike(String value) {
            addCriterion("SiteArea like", value, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteareaNotLike(String value) {
            addCriterion("SiteArea not like", value, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteareaIn(List<String> values) {
            addCriterion("SiteArea in", values, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteareaNotIn(List<String> values) {
            addCriterion("SiteArea not in", values, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteareaBetween(String value1, String value2) {
            addCriterion("SiteArea between", value1, value2, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteareaNotBetween(String value1, String value2) {
            addCriterion("SiteArea not between", value1, value2, "sitearea");
            return (Criteria) this;
        }

        public Criteria andSiteamountIsNull() {
            addCriterion("SiteAmount is null");
            return (Criteria) this;
        }

        public Criteria andSiteamountIsNotNull() {
            addCriterion("SiteAmount is not null");
            return (Criteria) this;
        }

        public Criteria andSiteamountEqualTo(Integer value) {
            addCriterion("SiteAmount =", value, "siteamount");
            return (Criteria) this;
        }

        public Criteria andSiteamountNotEqualTo(Integer value) {
            addCriterion("SiteAmount <>", value, "siteamount");
            return (Criteria) this;
        }

        public Criteria andSiteamountGreaterThan(Integer value) {
            addCriterion("SiteAmount >", value, "siteamount");
            return (Criteria) this;
        }

        public Criteria andSiteamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("SiteAmount >=", value, "siteamount");
            return (Criteria) this;
        }

        public Criteria andSiteamountLessThan(Integer value) {
            addCriterion("SiteAmount <", value, "siteamount");
            return (Criteria) this;
        }

        public Criteria andSiteamountLessThanOrEqualTo(Integer value) {
            addCriterion("SiteAmount <=", value, "siteamount");
            return (Criteria) this;
        }

        public Criteria andSiteamountIn(List<Integer> values) {
            addCriterion("SiteAmount in", values, "siteamount");
            return (Criteria) this;
        }

        public Criteria andSiteamountNotIn(List<Integer> values) {
            addCriterion("SiteAmount not in", values, "siteamount");
            return (Criteria) this;
        }

        public Criteria andSiteamountBetween(Integer value1, Integer value2) {
            addCriterion("SiteAmount between", value1, value2, "siteamount");
            return (Criteria) this;
        }

        public Criteria andSiteamountNotBetween(Integer value1, Integer value2) {
            addCriterion("SiteAmount not between", value1, value2, "siteamount");
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
package com.bookstore.demo.po;

import java.util.ArrayList;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andAddressIdIsNull() {
            addCriterion("address_id is null");
            return (Criteria) this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("address_id is not null");
            return (Criteria) this;
        }

        public Criteria andAddressIdEqualTo(Integer value) {
            addCriterion("address_id =", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotEqualTo(Integer value) {
            addCriterion("address_id <>", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThan(Integer value) {
            addCriterion("address_id >", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("address_id >=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThan(Integer value) {
            addCriterion("address_id <", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("address_id <=", value, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdIn(List<Integer> values) {
            addCriterion("address_id in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotIn(List<Integer> values) {
            addCriterion("address_id not in", values, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdBetween(Integer value1, Integer value2) {
            addCriterion("address_id between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("address_id not between", value1, value2, "addressId");
            return (Criteria) this;
        }

        public Criteria andAddressNameIsNull() {
            addCriterion("address_name is null");
            return (Criteria) this;
        }

        public Criteria andAddressNameIsNotNull() {
            addCriterion("address_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddressNameEqualTo(String value) {
            addCriterion("address_name =", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotEqualTo(String value) {
            addCriterion("address_name <>", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameGreaterThan(String value) {
            addCriterion("address_name >", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameGreaterThanOrEqualTo(String value) {
            addCriterion("address_name >=", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameLessThan(String value) {
            addCriterion("address_name <", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameLessThanOrEqualTo(String value) {
            addCriterion("address_name <=", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameLike(String value) {
            addCriterion("address_name like", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotLike(String value) {
            addCriterion("address_name not like", value, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameIn(List<String> values) {
            addCriterion("address_name in", values, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotIn(List<String> values) {
            addCriterion("address_name not in", values, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameBetween(String value1, String value2) {
            addCriterion("address_name between", value1, value2, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressNameNotBetween(String value1, String value2) {
            addCriterion("address_name not between", value1, value2, "addressName");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneIsNull() {
            addCriterion("address_phone is null");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneIsNotNull() {
            addCriterion("address_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneEqualTo(String value) {
            addCriterion("address_phone =", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotEqualTo(String value) {
            addCriterion("address_phone <>", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneGreaterThan(String value) {
            addCriterion("address_phone >", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("address_phone >=", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneLessThan(String value) {
            addCriterion("address_phone <", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneLessThanOrEqualTo(String value) {
            addCriterion("address_phone <=", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneLike(String value) {
            addCriterion("address_phone like", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotLike(String value) {
            addCriterion("address_phone not like", value, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneIn(List<String> values) {
            addCriterion("address_phone in", values, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotIn(List<String> values) {
            addCriterion("address_phone not in", values, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneBetween(String value1, String value2) {
            addCriterion("address_phone between", value1, value2, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressPhoneNotBetween(String value1, String value2) {
            addCriterion("address_phone not between", value1, value2, "addressPhone");
            return (Criteria) this;
        }

        public Criteria andAddressAddressIsNull() {
            addCriterion("address_address is null");
            return (Criteria) this;
        }

        public Criteria andAddressAddressIsNotNull() {
            addCriterion("address_address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressAddressEqualTo(String value) {
            addCriterion("address_address =", value, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andAddressAddressNotEqualTo(String value) {
            addCriterion("address_address <>", value, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andAddressAddressGreaterThan(String value) {
            addCriterion("address_address >", value, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andAddressAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address_address >=", value, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andAddressAddressLessThan(String value) {
            addCriterion("address_address <", value, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andAddressAddressLessThanOrEqualTo(String value) {
            addCriterion("address_address <=", value, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andAddressAddressLike(String value) {
            addCriterion("address_address like", value, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andAddressAddressNotLike(String value) {
            addCriterion("address_address not like", value, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andAddressAddressIn(List<String> values) {
            addCriterion("address_address in", values, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andAddressAddressNotIn(List<String> values) {
            addCriterion("address_address not in", values, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andAddressAddressBetween(String value1, String value2) {
            addCriterion("address_address between", value1, value2, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andAddressAddressNotBetween(String value1, String value2) {
            addCriterion("address_address not between", value1, value2, "addressAddress");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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
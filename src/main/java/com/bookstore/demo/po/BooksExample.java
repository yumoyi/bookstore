package com.bookstore.demo.po;

import java.util.ArrayList;
import java.util.List;

public class BooksExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BooksExample() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookPriceIsNull() {
            addCriterion("book_price is null");
            return (Criteria) this;
        }

        public Criteria andBookPriceIsNotNull() {
            addCriterion("book_price is not null");
            return (Criteria) this;
        }

        public Criteria andBookPriceEqualTo(Double value) {
            addCriterion("book_price =", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotEqualTo(Double value) {
            addCriterion("book_price <>", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceGreaterThan(Double value) {
            addCriterion("book_price >", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("book_price >=", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceLessThan(Double value) {
            addCriterion("book_price <", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceLessThanOrEqualTo(Double value) {
            addCriterion("book_price <=", value, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceIn(List<Double> values) {
            addCriterion("book_price in", values, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotIn(List<Double> values) {
            addCriterion("book_price not in", values, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceBetween(Double value1, Double value2) {
            addCriterion("book_price between", value1, value2, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookPriceNotBetween(Double value1, Double value2) {
            addCriterion("book_price not between", value1, value2, "bookPrice");
            return (Criteria) this;
        }

        public Criteria andBookImageIsNull() {
            addCriterion("book_image is null");
            return (Criteria) this;
        }

        public Criteria andBookImageIsNotNull() {
            addCriterion("book_image is not null");
            return (Criteria) this;
        }

        public Criteria andBookImageEqualTo(String value) {
            addCriterion("book_image =", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotEqualTo(String value) {
            addCriterion("book_image <>", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageGreaterThan(String value) {
            addCriterion("book_image >", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageGreaterThanOrEqualTo(String value) {
            addCriterion("book_image >=", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageLessThan(String value) {
            addCriterion("book_image <", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageLessThanOrEqualTo(String value) {
            addCriterion("book_image <=", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageLike(String value) {
            addCriterion("book_image like", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotLike(String value) {
            addCriterion("book_image not like", value, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageIn(List<String> values) {
            addCriterion("book_image in", values, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotIn(List<String> values) {
            addCriterion("book_image not in", values, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageBetween(String value1, String value2) {
            addCriterion("book_image between", value1, value2, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookImageNotBetween(String value1, String value2) {
            addCriterion("book_image not between", value1, value2, "bookImage");
            return (Criteria) this;
        }

        public Criteria andBookDescIsNull() {
            addCriterion("book_desc is null");
            return (Criteria) this;
        }

        public Criteria andBookDescIsNotNull() {
            addCriterion("book_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBookDescEqualTo(String value) {
            addCriterion("book_desc =", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotEqualTo(String value) {
            addCriterion("book_desc <>", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescGreaterThan(String value) {
            addCriterion("book_desc >", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescGreaterThanOrEqualTo(String value) {
            addCriterion("book_desc >=", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescLessThan(String value) {
            addCriterion("book_desc <", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescLessThanOrEqualTo(String value) {
            addCriterion("book_desc <=", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescLike(String value) {
            addCriterion("book_desc like", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotLike(String value) {
            addCriterion("book_desc not like", value, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescIn(List<String> values) {
            addCriterion("book_desc in", values, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotIn(List<String> values) {
            addCriterion("book_desc not in", values, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescBetween(String value1, String value2) {
            addCriterion("book_desc between", value1, value2, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookDescNotBetween(String value1, String value2) {
            addCriterion("book_desc not between", value1, value2, "bookDesc");
            return (Criteria) this;
        }

        public Criteria andBookFlagIsNull() {
            addCriterion("book_flag is null");
            return (Criteria) this;
        }

        public Criteria andBookFlagIsNotNull() {
            addCriterion("book_flag is not null");
            return (Criteria) this;
        }

        public Criteria andBookFlagEqualTo(Integer value) {
            addCriterion("book_flag =", value, "bookFlag");
            return (Criteria) this;
        }

        public Criteria andBookFlagNotEqualTo(Integer value) {
            addCriterion("book_flag <>", value, "bookFlag");
            return (Criteria) this;
        }

        public Criteria andBookFlagGreaterThan(Integer value) {
            addCriterion("book_flag >", value, "bookFlag");
            return (Criteria) this;
        }

        public Criteria andBookFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_flag >=", value, "bookFlag");
            return (Criteria) this;
        }

        public Criteria andBookFlagLessThan(Integer value) {
            addCriterion("book_flag <", value, "bookFlag");
            return (Criteria) this;
        }

        public Criteria andBookFlagLessThanOrEqualTo(Integer value) {
            addCriterion("book_flag <=", value, "bookFlag");
            return (Criteria) this;
        }

        public Criteria andBookFlagIn(List<Integer> values) {
            addCriterion("book_flag in", values, "bookFlag");
            return (Criteria) this;
        }

        public Criteria andBookFlagNotIn(List<Integer> values) {
            addCriterion("book_flag not in", values, "bookFlag");
            return (Criteria) this;
        }

        public Criteria andBookFlagBetween(Integer value1, Integer value2) {
            addCriterion("book_flag between", value1, value2, "bookFlag");
            return (Criteria) this;
        }

        public Criteria andBookFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("book_flag not between", value1, value2, "bookFlag");
            return (Criteria) this;
        }

        public Criteria andBookNumIsNull() {
            addCriterion("book_num is null");
            return (Criteria) this;
        }

        public Criteria andBookNumIsNotNull() {
            addCriterion("book_num is not null");
            return (Criteria) this;
        }

        public Criteria andBookNumEqualTo(Integer value) {
            addCriterion("book_num =", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumNotEqualTo(Integer value) {
            addCriterion("book_num <>", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumGreaterThan(Integer value) {
            addCriterion("book_num >", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_num >=", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumLessThan(Integer value) {
            addCriterion("book_num <", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumLessThanOrEqualTo(Integer value) {
            addCriterion("book_num <=", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumIn(List<Integer> values) {
            addCriterion("book_num in", values, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumNotIn(List<Integer> values) {
            addCriterion("book_num not in", values, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumBetween(Integer value1, Integer value2) {
            addCriterion("book_num between", value1, value2, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumNotBetween(Integer value1, Integer value2) {
            addCriterion("book_num not between", value1, value2, "bookNum");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
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
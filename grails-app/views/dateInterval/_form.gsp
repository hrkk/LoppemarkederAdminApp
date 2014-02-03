<%@ page import="dk.roninit.loppadmin.DateInterval" %>



<div class="fieldcontain ${hasErrors(bean: dateIntervalInstance, field: 'fromDate', 'error')} required">
	<label for="fromDate">
		<g:message code="dateInterval.fromDate.label" default="From Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fromDate" precision="day"  value="${dateIntervalInstance?.fromDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: dateIntervalInstance, field: 'toDate', 'error')} required">
	<label for="toDate">
		<g:message code="dateInterval.toDate.label" default="To Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="toDate" precision="day"  value="${dateIntervalInstance?.toDate}"  />
</div>


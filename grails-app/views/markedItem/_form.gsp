<%@ page import="loppemarkederadminapp.MarkedItem" %>



<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="markedItem.name.label" default="Name" />

	</label>
	<g:textField name="name" maxlength="50" value="${markedItemInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'address', 'error')} ">
	<label for="address">
		<g:message code="markedItem.address.label" default="Address" />

	</label>
	<g:textField name="address" maxlength="100" value="${markedItemInstance?.address}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'fromDate', 'error')} required">
	<label for="fromDate">
		<g:message code="markedItem.fromDate.label" default="From Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fromDate" precision="day"  value="${markedItemInstance?.fromDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'toDate', 'error')} ">
	<label for="toDate">
		<g:message code="markedItem.toDate.label" default="To Date" />

	</label>
	<g:datePicker name="toDate" precision="day"  value="${markedItemInstance?.toDate}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'dateExtraInfo', 'error')} ">
	<label for="dateExtraInfo">
		<g:message code="markedItem.dateExtraInfo.label" default="Date Extra Info" />

	</label>
	<g:textArea name="dateExtraInfo" cols="40" rows="5" maxlength="256" value="${markedItemInstance?.dateExtraInfo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'entreInfo', 'error')} ">
	<label for="entreInfo">
		<g:message code="markedItem.entreInfo.label" default="Entre Info" />

	</label>
	<g:textArea name="entreInfo" cols="40" rows="5" maxlength="256" value="${markedItemInstance?.entreInfo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'markedRules', 'error')} ">
	<label for="markedRules">
		<g:message code="markedItem.markedRules.label" default="Marked Rules" />

	</label>
	<g:textArea name="markedRules" cols="40" rows="5" maxlength="256" value="${markedItemInstance?.markedRules}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'markedInformation', 'error')} ">
	<label for="markedInformation">
		<g:message code="markedItem.markedInformation.label" default="Marked Information" />

	</label>
	<g:textArea name="markedInformation" cols="40" rows="5" maxlength="256" value="${markedItemInstance?.markedInformation}"/>
</div>

<div class="message">Brug denne website til at finde latitude og longitude: <a href="http://universimmedia.pagesperso-orange.fr/geo/loc.htm">http://universimmedia.pagesperso-orange.fr/geo/loc.htm</a></div>


<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'latitude', 'error')} required">
	<label for="latitude">
		<g:message code="markedItem.latitude.label" default="Latitude" />
		<span class="required-indicator">*</span>
	</label>
    <g:field name="latitude" value="${formatNumber(number: markedItemInstance?.latitude, minFractionDigits: 9)}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'longitude', 'error')} required">
	<label for="longitude">
		<g:message code="markedItem.longitude.label" default="Longitude" />
		<span class="required-indicator">*</span>
	</label>
    <g:field name="longitude" value="${formatNumber(number: markedItemInstance?.longitude, minFractionDigits: 9)}" required=""/>
</div>



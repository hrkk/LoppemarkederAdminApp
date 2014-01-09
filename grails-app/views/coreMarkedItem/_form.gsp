<%@ page import="dk.roninit.loppadmin.CoreMarkedItem" %>



<div class="fieldcontain ${hasErrors(bean: coreMarkedItemInstance, field: 'createdBy', 'error')} ">
	<label for="createdBy">
		<g:message code="coreMarkedItem.createdBy.label" default="Created By" />
		
	</label>
	<g:textField name="createdBy" value="${coreMarkedItemInstance?.createdBy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coreMarkedItemInstance, field: 'modifiedBy', 'error')} ">
	<label for="modifiedBy">
		<g:message code="coreMarkedItem.modifiedBy.label" default="Modified By" />
		
	</label>
	<g:textField name="modifiedBy" value="${coreMarkedItemInstance?.modifiedBy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coreMarkedItemInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="coreMarkedItem.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${coreMarkedItemInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coreMarkedItemInstance, field: 'additionalOpenTimePeriod', 'error')} ">
	<label for="additionalOpenTimePeriod">
		<g:message code="coreMarkedItem.additionalOpenTimePeriod.label" default="Additional Open Time Period" />
		
	</label>
	<g:textArea name="additionalOpenTimePeriod" cols="40" rows="5" maxlength="256" value="${coreMarkedItemInstance?.additionalOpenTimePeriod}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coreMarkedItemInstance, field: 'entreInfo', 'error')} required">
	<label for="entreInfo">
		<g:message code="coreMarkedItem.entreInfo.label" default="Entre Info" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="entreInfo" cols="40" rows="5" maxlength="256" required="" value="${coreMarkedItemInstance?.entreInfo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coreMarkedItemInstance, field: 'markedRules', 'error')} required">
	<label for="markedRules">
		<g:message code="coreMarkedItem.markedRules.label" default="Marked Rules" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="markedRules" cols="40" rows="5" maxlength="256" required="" value="${coreMarkedItemInstance?.markedRules}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coreMarkedItemInstance, field: 'markedInformation', 'error')} required">
	<label for="markedInformation">
		<g:message code="coreMarkedItem.markedInformation.label" default="Marked Information" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="markedInformation" cols="40" rows="5" maxlength="256" required="" value="${coreMarkedItemInstance?.markedInformation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coreMarkedItemInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="coreMarkedItem.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${coreMarkedItemInstance?.enabled}" />
</div>

<div class="fieldcontain ${hasErrors(bean: coreMarkedItemInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="coreMarkedItem.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="address" name="address.id" from="${dk.roninit.loppadmin.Address.list()}" optionKey="id" required="" value="${coreMarkedItemInstance?.address?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coreMarkedItemInstance, field: 'dateInterval', 'error')} ">
	<label for="dateInterval">
		<g:message code="coreMarkedItem.dateInterval.label" default="Date Interval" />
		
	</label>
	<g:select name="dateInterval" from="${dk.roninit.loppadmin.DateInterval.list()}" multiple="multiple" optionKey="id" size="5" value="${coreMarkedItemInstance?.dateInterval*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coreMarkedItemInstance, field: 'organizer', 'error')} required">
	<label for="organizer">
		<g:message code="coreMarkedItem.organizer.label" default="Organizer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="organizer" name="organizer.id" from="${dk.roninit.loppadmin.Organizer.list()}" optionKey="id" required="" value="${coreMarkedItemInstance?.organizer?.id}" class="many-to-one"/>
</div>


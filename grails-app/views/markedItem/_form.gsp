<%@ page import="dk.roninit.loppadmin.MarkedItem" %>



<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'createdBy', 'error')} ">
	<label for="createdBy">
		<g:message code="markedItem.createdBy.label" default="Created By" />
		
	</label>
	<g:textField name="createdBy" value="${markedItemInstance?.createdBy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'modifiedBy', 'error')} ">
	<label for="modifiedBy">
		<g:message code="markedItem.modifiedBy.label" default="Modified By" />
		
	</label>
	<g:textField name="modifiedBy" value="${markedItemInstance?.modifiedBy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="markedItem.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="50" required="" value="${markedItemInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'additionalOpenTimePeriod', 'error')} ">
	<label for="additionalOpenTimePeriod">
		<g:message code="markedItem.additionalOpenTimePeriod.label" default="Additional Open Time Period" />
		
	</label>
	<g:textArea name="additionalOpenTimePeriod" cols="40" rows="5" maxlength="256" value="${markedItemInstance?.additionalOpenTimePeriod}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'entreInfo', 'error')} required">
	<label for="entreInfo">
		<g:message code="markedItem.entreInfo.label" default="Entre Info" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="entreInfo" cols="40" rows="5" maxlength="256" required="" value="${markedItemInstance?.entreInfo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'markedRules', 'error')} required">
	<label for="markedRules">
		<g:message code="markedItem.markedRules.label" default="Marked Rules" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="markedRules" cols="40" rows="5" maxlength="256" required="" value="${markedItemInstance?.markedRules}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'markedInformation', 'error')} required">
	<label for="markedInformation">
		<g:message code="markedItem.markedInformation.label" default="Marked Information" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="markedInformation" cols="40" rows="5" maxlength="256" required="" value="${markedItemInstance?.markedInformation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="markedItem.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="address" name="address.id" from="${dk.roninit.loppadmin.Address.list()}" optionKey="id" required="" value="${markedItemInstance?.address?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'dateInterval', 'error')} ">
	<label for="dateInterval">
		<g:message code="markedItem.dateInterval.label" default="Date Interval" />
		
	</label>
	<g:select name="dateInterval" from="${dk.roninit.loppadmin.DateInterval.list()}" multiple="multiple" optionKey="id" size="5" value="${markedItemInstance?.dateInterval*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: markedItemInstance, field: 'organizer', 'error')} required">
	<label for="organizer">
		<g:message code="markedItem.organizer.label" default="Organizer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="organizer" name="organizer.id" from="${dk.roninit.loppadmin.Organizer.list()}" optionKey="id" required="" value="${markedItemInstance?.organizer?.id}" class="many-to-one"/>
</div>


<table>
    <tr>
        <td colspan="2">
        Marked <a href="http://roninit.dk/LoppemarkederAdminApp/coreMarkedItem/show/${marked.id}"> ${marked}</a> er oprettet fra mobil appen. Markedet er aktiveret og kan se i markeds oversigten.
        Hvis markedet ikke skal vises, skal du selv fjerne det fra listen ved at disable det og evt. sende mail til markeds opretteren.
        </td>
    </tr>
    <tr>
        <td colspan="2"> </td>
    </tr>
    <tr>
        <td colspan="2"><b>Markeds Arrangør</b></td>
    </tr>
    <tr>
        <td>Navn</td>
        <td>${view.organizerName}</td>
    </tr>

    <tr>
        <td>E-mail</td>
        <td>${view.organizerEmail}</td>
    </tr>
    <tr>
        <td>Telefon nr.</td>
        <td>${view.organizerPhone}</td>
    </tr>
    <tr>
        <td colspan="2"><b>Markeds data</b></td>
    </tr>
    <tr>
        <td>Markedsnavn</td>
        <td>${view.name}</td>
    </tr>
    <tr>
        <td>Adresse</td>
        <td>${view.address}</td>
    </tr>
    <tr>
        <td>Latitude</td>
        <td>${view.latitude}</td>
    </tr>
    <tr>
        <td>Longitude</td>
        <td>${view.longitude}</td>
    </tr>
    <tr>
        <td>Fra dato</td>
        <td>${view.fromDateAsString}</td>
    </tr>
    <tr>
        <td>Til dato</td>
        <td>${view.toDateAsString}</td>
    </tr>
    <tr>
        <td>Evt. åbent tidsrum</td>
        <td>${view.additionalOpenTimePeriod}</td>
    </tr>
    <tr>
        <td>Entre pris</td>
        <td>${view.entreInfo}</td>
    </tr>
    <tr>
        <td>Regler</td>
        <td>${view.markedRules}</td>
    </tr>
    <tr>
        <td>Markeds information</td>
        <td>${view.markedInformation}</td>
    </tr>
</table>
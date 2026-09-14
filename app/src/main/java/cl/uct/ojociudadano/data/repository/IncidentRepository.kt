package cl.uct.ojociudadano.data.repository

import cl.uct.ojociudadano.data.model.Incident

interface IncidentRepository {

    suspend fun getIncidents(): List<Incident>

    suspend fun getIncidentById(id: String): Incident?

    suspend fun createIncident(incident: Incident)
}

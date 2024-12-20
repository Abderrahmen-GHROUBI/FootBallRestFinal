const API_BASE_URL = 'http://localhost:9090/api';

const api = {
    // Competition endpoints
    async getAllCompetitions() {
        const response = await fetch(`${API_BASE_URL}/competitions`);
        return response.json();
    },

    async getCompetition(id) {
        const response = await fetch(`${API_BASE_URL}/competitions/${id}`);
        return response.json();
    },

    async createCompetition(competition) {
        const response = await fetch(`${API_BASE_URL}/competitions`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(competition),
        });
        return response.json();
    },

    async updateCompetition(id, competition) {
        const response = await fetch(`${API_BASE_URL}/competitions/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(competition),
        });
        return response.json();
    },

    async deleteCompetition(id) {
        await fetch(`${API_BASE_URL}/competitions/${id}`, {
            method: 'DELETE',
        });
    },

    async getCompetitionsByCountry(country) {
        const response = await fetch(`${API_BASE_URL}/competitions/country/${country}`);
        return response.json();
    },

    // Match endpoints
    async getAllMatches() {
        const response = await fetch(`${API_BASE_URL}/matches`);
        return response.json();
    },

    async getMatch(id) {
        const response = await fetch(`${API_BASE_URL}/matches/${id}`);
        return response.json();
    },

    async createMatch(match) {
        const response = await fetch(`${API_BASE_URL}/matches`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(match),
        });
        return response.json();
    },

    async updateMatch(id, match) {
        const response = await fetch(`${API_BASE_URL}/matches/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(match),
        });
        return response.json();
    },

    async deleteMatch(id) {
        await fetch(`${API_BASE_URL}/matches/${id}`, {
            method: 'DELETE',
        });
    },

    async getMatchesByCompetition(competition) {
        const response = await fetch(`${API_BASE_URL}/matches/competition/${competition}`);
        return response.json();
    },
};

// DOM Elements
const navLinks = document.querySelectorAll('.nav-links li');
const views = document.querySelectorAll('.view');
const competitionsGrid = document.getElementById('competitions-grid');
const matchesList = document.getElementById('matches-list');
const competitionModal = document.getElementById('competition-modal');
const matchModal = document.getElementById('match-modal');
const competitionForm = document.getElementById('competition-form');
const matchForm = document.getElementById('match-form');
const competitionSelect = document.getElementById('competition-select');

// State
let competitions = [];
let matches = [];
let currentCompetitionId = null;
let currentMatchId = null;

// Navigation
navLinks.forEach(link => {
    link.addEventListener('click', () => {
        navLinks.forEach(l => l.classList.remove('active'));
        views.forEach(v => v.classList.remove('active'));
        link.classList.add('active');
        document.querySelector(`.${link.dataset.view}-view`).classList.add('active');
    });
});

// Competition Functions
async function loadCompetitions() {
    try {
        competitions = await api.getAllCompetitions();
        renderCompetitions();
        updateCompetitionSelect();
    } catch (error) {
        console.error('Error loading competitions:', error);
    }
}

function renderCompetitions() {
    competitionsGrid.innerHTML = competitions.map(competition => `
        <div class="competition-card">
            <h3>${competition.name}</h3>
            <div class="competition-info">
                <p><span>Country:</span> <span>${competition.country}</span></p>
                <p><span>Year:</span> <span>${competition.year}</span></p>
                <p><span>Winner:</span> <span>${competition.winner}</span></p>
                <p><span>Runner-up:</span> <span>${competition.runnerup}</span></p>
            </div>
            <div class="competition-actions">
                <button class="btn-edit" onclick="editCompetition(${competition.id})">
                    <i class="material-icons">edit</i> Edit
                </button>
                <button class="btn-delete" onclick="deleteCompetition(${competition.id})">
                    <i class="material-icons">delete</i> Delete
                </button>
            </div>
        </div>
    `).join('');
}

function updateCompetitionSelect() {
    competitionSelect.innerHTML = `
        <option value="">Select Competition</option>
        ${competitions.map(c => `
            <option value="${c.name}">${c.name}</option>
        `).join('')}
    `;
}

function openCompetitionModal() {
    currentCompetitionId = null;
    competitionForm.reset();
    competitionModal.classList.add('active');
}

function closeCompetitionModal() {
    competitionModal.classList.remove('active');
}

function editCompetition(id) {
    const competition = competitions.find(c => c.id === id);
    if (competition) {
        currentCompetitionId = id;
        const form = competitionForm;
        form.name.value = competition.name;
        form.country.value = competition.country;
        form.year.value = competition.year;
        form.winner.value = competition.winner;
        form.runnerup.value = competition.runnerup;
        competitionModal.classList.add('active');
    }
}

async function deleteCompetition(id) {
    if (confirm('Are you sure you want to delete this competition?')) {
        try {
            await api.deleteCompetition(id);
            await loadCompetitions();
        } catch (error) {
            console.error('Error deleting competition:', error);
        }
    }
}

// Match Functions
async function loadMatches() {
    try {
        matches = await api.getAllMatches();
        renderMatches();
    } catch (error) {
        console.error('Error loading matches:', error);
    }
}

function renderMatches() {
    matchesList.innerHTML = matches.map(match => `
        <div class="match-card">
            <div class="match-header">
                <span>${match.competition}</span>
                <span>${match.round}</span>
            </div>
            <div class="match-teams">
                <span>${match.team1}</span>
                <div class="match-score">${match.team1goals} - ${match.team2goals}</div>
                <span>${match.team2}</span>
            </div>
            <div class="match-info">
                <span>Year: ${match.year}</span>
                <div class="match-actions">
                    <button class="btn-edit" onclick="editMatch(${match.id})">
                        <i class="material-icons">edit</i> Edit
                    </button>
                    <button class="btn-delete" onclick="deleteMatch(${match.id})">
                        <i class="material-icons">delete</i> Delete
                    </button>
                </div>
            </div>
        </div>
    `).join('');
}

function openMatchModal() {
    currentMatchId = null;
    matchForm.reset();
    matchModal.classList.add('active');
}

function closeMatchModal() {
    matchModal.classList.remove('active');
}

function editMatch(id) {
    const match = matches.find(m => m.id === id);
    if (match) {
        currentMatchId = id;
        const form = matchForm;
        form.competition.value = match.competition;
        form.year.value = match.year;
        form.round.value = match.round;
        form.team1.value = match.team1;
        form.team2.value = match.team2;
        form.team1goals.value = match.team1goals;
        form.team2goals.value = match.team2goals;
        matchModal.classList.add('active');
    }
}

async function deleteMatch(id) {
    if (confirm('Are you sure you want to delete this match?')) {
        try {
            await api.deleteMatch(id);
            await loadMatches();
        } catch (error) {
            console.error('Error deleting match:', error);
        }
    }
}

// Form Submissions
competitionForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const formData = new FormData(competitionForm);
    const competition = {
        name: formData.get('name'),
        country: formData.get('country'),
        year: parseInt(formData.get('year')),
        winner: formData.get('winner'),
        runnerup: formData.get('runnerup')
    };

    try {
        if (currentCompetitionId) {
            await api.updateCompetition(currentCompetitionId, competition);
        } else {
            await api.createCompetition(competition);
        }
        closeCompetitionModal();
        await loadCompetitions();
    } catch (error) {
        console.error('Error saving competition:', error);
    }
});

matchForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const formData = new FormData(matchForm);
    const match = {
        competition: formData.get('competition'),
        year: parseInt(formData.get('year')),
        round: formData.get('round'),
        team1: formData.get('team1'),
        team2: formData.get('team2'),
        team1goals: parseInt(formData.get('team1goals')),
        team2goals: parseInt(formData.get('team2goals'))
    };

    try {
        if (currentMatchId) {
            await api.updateMatch(currentMatchId, match);
        } else {
            await api.createMatch(match);
        }
        closeMatchModal();
        await loadMatches();
    } catch (error) {
        console.error('Error saving match:', error);
    }
});

// Initial Load
loadCompetitions();
loadMatches();

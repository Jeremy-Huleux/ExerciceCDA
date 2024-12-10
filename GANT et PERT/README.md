# Exercices de la Formation CDA Bac+4

Ce dépôt contient les exercices réalisés dans le cadre de ma formation **Concepteur Développeur d’Applications (CDA) Bac+4**. Parmi ces exercices, j'ai travaillé sur la planification de projets à l'aide des outils **PERT** et **GANTT**, en répondant aux problématiques suivantes : identification des antécédents, calcul des marges, détermination du chemin critique, et création d'un planning.

## 📋 Contexte de l'exercice

### Données initiales

Les tâches d’un projet sont définies dans le tableau ci-dessous :

| **Tâche** | **Antécédent(s)** | **Durée (en jours)** |
|-----------|-------------------|----------------------|
| T1        | -                 | 10                   |
| T2        | -                 | 5                    |
| T3        | T1               | 8                    |
| T4        | T2               | 10                   |
| T5        | T2               | 10                   |
| T6        | T3, T4           | 25                   |
| T7        | T5               | 4                    |
| T8        | T3               | 10                   |
| T9        | T8               | 2                    |
| T10       | T8               | 1                    |
| T11       | T6, T7, T8       | 15                   |
| T12       | T11              | 10                   |
| T13       | T12              | 12                   |
| T14       | T9, T10, T11     | 30                   |

### Objectifs
1. **Diagramme de PERT** :
   - Construire le diagramme de PERT avec les dates de début **au plus tôt** et **au plus tard**.
   - Calculer les **marges** pour chaque tâche.
   - Identifier et mettre en évidence le **chemin critique**.

2. **Diagramme de GANTT** :
   - Proposer un planning basé sur les dates **au plus tard** obtenues via le PERT.

---

## 📊 Travail réalisé

### Diagramme de PERT
- Le diagramme PERT a été construit en suivant la logique des dépendances définies dans le tableau des antécédents.
- Les calculs effectués incluent :
  - Les dates de début **au plus tôt** et **au plus tard**.
  - Les **marges totales** et **libres** de chaque tâche.
  - Le **chemin critique**, identifié et représenté clairement.

Vous pouvez consulter le diagramme PERT dans le fichier :  
`diagramme_pert.png`

---

### Diagramme de GANTT
- Un planning détaillé des tâches a été élaboré à partir des données du PERT, en utilisant les dates **au plus tard**.
- Ce diagramme permet de visualiser facilement la répartition des tâches dans le temps.

Le diagramme GANTT est disponible dans le fichier :  
`diagramme_gantt.png`

---

## 🛠️ Technologies utilisées
- Outils de dessin et de planification : **Draw.io**, **Excel**, ou autre outil graphique.
- Gestion des versions : **Git** et **GitHub**.

---

## 🚀 Comment utiliser ce dépôt ?
1. Clonez le dépôt :
   ```bash
   git clone https://github.com/[VotrePseudo]/exercices_CDA.git

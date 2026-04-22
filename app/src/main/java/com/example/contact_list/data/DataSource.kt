/* LISTE DE CONTACT GÉNÉRÉE PAR DÉFAUT */
package com.example.contact_list.data

import com.example.contact_list.model.Contact

object DataSource {
    fun loadData(): List<Contact> {
        return listOf(
            Contact(1, "Cabrera", "Yasmina", "EBGames", "514-111-1111", "514-222-2222", "yasmina@email.com", "9462 avenue Champs"),
            Contact(2, "Tremblay", "Luc", "", "438-438-2345", "514-970-9876", "", "123 rue Sainte-Catherine"),
            Contact(3, "Nguyen", "Linh", "Ubisoft", "", "438-093-6543", "linh.nguyen@email.com", ""),
            Contact(4, "", "Marc", "Desjardins", "438-450-4567", "514-450-7654", "marc.gagnon@email.com", ""),
            Contact(5, "Roy", "Sophie", "", "438-438-5678", "438-865-8765", "", "321 rue Sherbrooke"),
            Contact(6, "Côté", "Antoine", "Metro", "", "438-536-9876", "antoine.cote@email.com", "654 avenue Laurier"),
            Contact(7, "Bouchard", "Emily", "", "438-450-7890", "514-450-0987", "emilie.bouchard@email.com", ""),
            Contact(8, "", "Julien", "", "514-330-8901", "514-826-1098", "", "147 avenue Mont-Royal"),
            Contact(9, "Lavoie", "Camille", "Hydro-Québec", "", "438-475-2109", "", "258 rue Saint-Denis"),
            Contact(10, "Latortue", "Jaynelle", "", "438-555-5555", "438-666-6666", "choco.melonpan@email.com", ""),
            Contact(11, "Morin", "Jade", "National Bank", "438-450-1234", "438-450-4321", "", "741 rue Peel"),
            Contact(12, "", "Samuel", "Cirque du Soleil", "", "438-330-5432", "samuel.pelletier@email.com", "852 avenue Papineau"),
            Contact(13, "Leblanc", "Chloé", "", "438-438-3456", "438-438-6543", "", ""),
            Contact(14, "Gauthier", "Alexis", "Intact", "", "514-312-7654", "alexis.gauthier@email.com", "159 avenue Atwater"),
            Contact(15, "", "Maëva", "", "444-450-5678", "438-450-8765", "maeva.bergeron@email.com", "357 rue Beaubien"),
            Contact(16, "Paradis", "Nicolas", "Couche-Tard", "514-873-6789", "438-009-9876", "", ""),
            Contact(17, "Leclerc", "Laurie", "", "", "111-438-0987", "laurie.leclerc@email.com", "624 rue Duluth"),
            Contact(18, "Savard", "Gabriel", "CAE", "514-837-8901", "514-514-1098", "", "753 avenue Victoria"),
            Contact(19, "", "Rosalie", "Moment Factory", "", "438-450-2109", "rosalie.poirier@email.com", ""),
            Contact(20, "Cloutier", "Félix", "", "514-352-0123", "438-028-3210", "", "972 avenue Dollard"),
        )
    }
}
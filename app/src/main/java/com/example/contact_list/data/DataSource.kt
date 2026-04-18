package com.example.contact_list.data

import com.example.contact_list.model.Contact

object DataSource {
    fun loadData(): List<Contact> {
        return listOf(
            Contact(1, "Cabrera", "Yasmina", "EBGames", "111-111-1111", "222-222-2222", "yasmina@email.com", "9462 avenue Champs", ""),
            Contact(2, "Tremblay", "Luc", "", "111-514-2345", "438-9876", "", "123 rue Sainte-Catherine", ""),
            Contact(3, "Nguyen", "Linh", "Ubisoft", "", "222-514-6543", "linh.nguyen@email.com", "", ""),
            Contact(4, "", "Marc", "Desjardins", "666-450-4567", "444-450-7654", "marc.gagnon@email.com", "", ""),
            Contact(5, "Roy", "Sophie", "", "222-438-5678", "438-8765", "", "321 rue Sherbrooke", ""),
            Contact(6, "Côté", "Antoine", "Metro", "", "888-514-9876", "antoine.cote@email.com", "654 avenue Laurier", ""),
            Contact(7, "Bouchard", "Émilie", "", "444-450-7890", "666-450-0987", "emilie.bouchard@email.com", "", ""),
            Contact(8, "", "Julien", "", "333-514-8901", "777-514-1098", "", "147 avenue Mont-Royal", ""),
            Contact(9, "Lavoie", "Camille", "Hydro-Québec", "", "438-2109", "", "258 rue Saint-Denis", ""),
            Contact(10, "Latortue", "Jaynelle", "", "555-555-5555", "666-666-6666", "choco.melonpan@email.com", "", ""),
            Contact(11, "Morin", "Jade", "National Bank", "666-450-1234", "444-450-4321", "", "741 rue Peel", ""),
            Contact(12, "", "Samuel", "Cirque du Soleil", "", "999-514-5432", "samuel.pelletier@email.com", "852 avenue Papineau", ""),
            Contact(13, "Leblanc", "Chloé", "", "777-438-3456", "888-438-6543", "", "", ""),
            Contact(14, "Gauthier", "Alexis", "Intact", "", "666-514-7654", "alexis.gauthier@email.com", "159 avenue Atwater", ""),
            Contact(15, "", "Maëva", "", "444-450-5678", "555-450-8765", "maeva.bergeron@email.com", "357 rue Beaubien", ""),
            Contact(16, "Paradis", "Nicolas", "Couche-Tard", "333-514-6789", "222-514-9876", "", "", ""),
            Contact(17, "Leclerc", "Laurie", "", "", "111-438-0987", "laurie.leclerc@email.com", "624 rue Duluth", ""),
            Contact(18, "Savard", "Gabriel", "CAE", "333-514-8901", "555-514-1098", "", "753 avenue Victoria", ""),
            Contact(19, "", "Rosalie", "Moment Factory", "", "777-450-2109", "rosalie.poirier@email.com", "", ""),
            Contact(20, "Cloutier", "Félix", "", "444-514-0123", "555-514-3210", "", "972 avenue Dollard", ""),
        )
    }
}
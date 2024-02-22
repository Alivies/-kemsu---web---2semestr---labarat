class Contact(val name: String, var phoneNumber: String)

class MobilePhone(val ownerNumber: String) {
    val contacts = mutableListOf<Contact>()

    fun addContact(name: String, phoneNumber: String) {
        contacts.add(Contact(name, phoneNumber))
        println("Контакт $name с номером $phoneNumber успешно добавлен.")
    }

    fun deleteContact(name: String) {
        val contact = contacts.find { it.name == name }
        if (contact != null) {
            contacts.remove(contact)
            println("Контакт $name успешно удален.")
        } else {
            println("Контакт $name не найден в записной книжке.")
        }
    }

    fun updateContact(name: String, newPhoneNumber: String) {
        val contact = contacts.find { it.name == name }
        if (contact != null) {
            contact.phoneNumber = newPhoneNumber
            println("Номер телефона контакта $name обновлен на $newPhoneNumber.")
        } else {
            println("Контакт $name не найден в записной книжке.")
        }
    }
}

fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))
    val mobilePhone = MobilePhone("123-456-7890")

    mobilePhone.addContact("Вася", "111-222-333")
    mobilePhone.addContact("Петя", "444-555-666")
    mobilePhone.addContact("Маша", "777-888-999")

    mobilePhone.contacts.forEach { println("${it.name}: ${it.phoneNumber}") }

    mobilePhone.deleteContact("Петя")

    mobilePhone.contacts.forEach { println("${it.name}: ${it.phoneNumber}") }

    mobilePhone.updateContact("Вася", "999-888-777")

    mobilePhone.contacts.forEach { println("${it.name}: ${it.phoneNumber}") }
}

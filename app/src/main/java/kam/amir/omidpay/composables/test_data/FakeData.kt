package kam.amir.omidpay.composables.test_data

import kam.amir.omidpay.room.product.Product
import kam.amir.omidpay.room.product.ProductMerged

class FakeData {


    companion object {

        val loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum pellentesque velit ultricies, vulputate nulla a, vehicula nisi. Quisque quis orci eu erat aliquet aliquet. Suspendisse eget vulputate leo. Curabitur vitae libero hendrerit, aliquam nulla in, tincidunt eros. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nam sed malesuada eros, eget pretium justo. Quisque ut elit ultricies, consequat leo at, blandit turpis. Integer dignissim risus id porta convallis. Nulla molestie ante arcu. Suspendisse ultrices blandit neque. Etiam fermentum a ipsum ac tempus. In vehicula sodales turpis, id hendrerit turpis placerat et. Duis pulvinar luctus neque, et dapibus mauris efficitur sed. Aenean fermentum ipsum at neque aliquet, et pellentesque lectus rutrum. In non risus vel sem interdum posuere non et turpis. Sed sodales tempus lorem ut lobortis.\n" +
                "\n" +
                "In eu aliquet nibh, id laoreet velit. Etiam blandit justo non arcu interdum pretium. Donec ac vulputate sem, at dignissim augue. Morbi at fringilla metus, at auctor orci. Proin elementum orci nec egestas laoreet. Aliquam posuere vehicula ex, eu sodales purus semper at. Nunc varius molestie velit, nec maximus mi placerat at. Proin rhoncus gravida erat ut dignissim. Sed quis scelerisque lorem. Vestibulum molestie in augue eget eleifend. Mauris est sapien, porta ac ligula eu, cursus sagittis felis. Proin sit amet tellus semper, interdum metus a, placerat massa. Duis feugiat euismod nisi.\n" +
                "\n" +
                "Maecenas et aliquam nisl. Integer in erat vulputate, tempor ante eget, pharetra purus. Integer finibus turpis vitae lectus ultricies iaculis. Sed semper at enim at fringilla. Suspendisse feugiat dolor nisl, vel dignissim lorem congue eget. Quisque sit amet sollicitudin dui. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur diam tortor, dignissim in faucibus porta, congue ac felis. Cras sodales nec diam vel volutpat. Donec mollis pharetra feugiat. Maecenas sollicitudin ut nunc sed maximus.\n" +
                "\n" +
                "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut vel enim in lectus luctus sagittis. Nulla nec tellus quis sapien rhoncus pretium. Nulla facilisi. Donec rhoncus lacus sapien, nec iaculis magna venenatis a. Quisque luctus nibh elit, nec hendrerit nulla condimentum fermentum. In sit amet egestas sapien. Integer ut sollicitudin ipsum. Nullam efficitur, lectus at lobortis viverra, massa urna dapibus erat, volutpat porttitor massa tellus eget neque. Donec quis aliquam ante, at faucibus turpis.\n" +
                "\n" +
                "Nulla blandit lectus at congue rutrum. Sed ullamcorper ornare metus eu aliquet. Cras quis diam id ex vulputate consectetur. Integer a leo et nisi consectetur ultricies. Sed eleifend tortor eu pellentesque egestas. Vivamus vitae urna vel nisi maximus vestibulum. Praesent viverra laoreet tempor. Morbi tincidunt nulla at enim aliquet, ac maximus mauris elementum. Cras sed mattis arcu, sit amet volutpat purus. Aliquam viverra urna felis, sit amet pharetra sem efficitur eget. Donec tempor molestie euismod. Maecenas interdum ipsum et luctus finibus. In congue at tortor et suscipit."


        val product = Product(
            title = "Title",
            price = 29.99,
            description = loremIpsum,
            id = 0,
            category = "category",
            image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"
        )

        val productMerged = ProductMerged(
            product = product,
            true
        )

        val products: List<Product> =
            listOf(product, product, product, product, product, product, product, product)

        val productMergeds : List<ProductMerged> = listOf(productMerged,productMerged,productMerged,productMerged,productMerged,productMerged)

    }


}


# OffersCarrousel Component

## Overview

The `OffersCarrousel` component is a reusable Jetpack Compose carousel component for displaying cards with images, optional text overlays, and click actions.

## Features

- ✅ Display a horizontal carousel of cards
- ✅ Support for images with automatic loading and error states
- ✅ Optional text overlay with gradient background
- ✅ Optional click actions for each card
- ✅ Customizable dimensions (height, item width, spacing)
- ✅ Backward compatibility with legacy `Offer` data class

## Usage

### Basic Usage with CarouselCard

```kotlin
val cards = listOf(
    CarouselCard(
        id = "1",
        imageUrl = "https://example.com/image1.jpg",
        text = "Summer Sale",
        onClick = { 
            // Handle click action
            navigateToOfferDetails("1")
        }
    ),
    CarouselCard(
        id = "2",
        imageUrl = "https://example.com/image2.jpg",
        text = "New Arrivals"
        // No onClick - card is not clickable
    ),
    CarouselCard(
        id = "3",
        imageUrl = "https://example.com/image3.jpg"
        // No text or onClick - just shows image
    )
)

OffersCarrousel(cards = cards)
```

### Custom Dimensions

```kotlin
OffersCarrousel(
    cards = cards,
    height = 250.dp,
    preferredItemWidth = 350.dp,
    itemSpacing = 12.dp
)
```

### Legacy Usage (Backward Compatibility)

The component still supports the legacy `Offer` data class:

```kotlin
val offers = listOf(
    Offer(id = "1", imageUrl = "https://example.com/image1.jpg"),
    Offer(id = "2", imageUrl = "https://example.com/image2.jpg")
)

OffersCarrousel(offers = offers)
```

### Converting Offer to CarouselCard

You can use the extension function to convert `Offer` to `CarouselCard` with additional features:

```kotlin
val enhancedCards = offers.map { offer ->
    offer.toCarouselCard(
        text = "Offer ${offer.id}",
        onClick = { handleOfferClick(offer.id) }
    )
}

OffersCarrousel(cards = enhancedCards)
```

## Data Classes

### CarouselCard

```kotlin
data class CarouselCard(
    val id: String,              // Unique identifier for the card
    val imageUrl: String,        // URL of the image to display
    val text: String? = null,    // Optional text overlay
    val onClick: (() -> Unit)? = null  // Optional click callback
)
```

### Offer (Legacy)

```kotlin
data class Offer(
    val id: String,
    val imageUrl: String
)
```

## Parameters

### OffersCarrousel

| Parameter | Type | Default | Description |
|-----------|------|---------|-------------|
| `cards` | `List<CarouselCard>` | Required | List of cards to display |
| `modifier` | `Modifier` | `Modifier` | Modifier for the carousel container |
| `height` | `Dp` | `200.dp` | Height of the carousel |
| `preferredItemWidth` | `Dp` | `300.dp` | Preferred width for each item |
| `itemSpacing` | `Dp` | `8.dp` | Spacing between carousel items |

## Examples

### Example 1: Product Showcase

```kotlin
val products = listOf(
    CarouselCard(
        id = "prod1",
        imageUrl = "https://cdn.example.com/product1.jpg",
        text = "Smartphone - $599",
        onClick = { viewProduct("prod1") }
    ),
    CarouselCard(
        id = "prod2",
        imageUrl = "https://cdn.example.com/product2.jpg",
        text = "Laptop - $999",
        onClick = { viewProduct("prod2") }
    )
)

OffersCarrousel(cards = products)
```

### Example 2: Featured Content

```kotlin
val featuredContent = listOf(
    CarouselCard(
        id = "feat1",
        imageUrl = "https://cdn.example.com/banner1.jpg",
        text = "Featured Article",
        onClick = { openArticle("feat1") }
    ),
    CarouselCard(
        id = "feat2",
        imageUrl = "https://cdn.example.com/banner2.jpg",
        onClick = { openVideo("feat2") }
    )
)

OffersCarrousel(
    cards = featuredContent,
    height = 300.dp,
    preferredItemWidth = 400.dp
)
```

### Example 3: Image Gallery (No Text, No Click)

```kotlin
val galleryImages = listOf(
    CarouselCard(id = "img1", imageUrl = "https://cdn.example.com/photo1.jpg"),
    CarouselCard(id = "img2", imageUrl = "https://cdn.example.com/photo2.jpg"),
    CarouselCard(id = "img3", imageUrl = "https://cdn.example.com/photo3.jpg")
)

OffersCarrousel(cards = galleryImages)
```

## Migration Guide

If you're currently using the legacy `Offer` data class, no changes are required - the component is fully backward compatible. However, to take advantage of the new features:

1. Replace `Offer` with `CarouselCard` in your code
2. Add optional `text` parameter for text overlays
3. Add optional `onClick` parameter for click handling

Before:
```kotlin
val offers = listOf(
    Offer(id = "1", imageUrl = "https://example.com/image.jpg")
)
OffersCarrousel(offers = offers)
```

After:
```kotlin
val cards = listOf(
    CarouselCard(
        id = "1",
        imageUrl = "https://example.com/image.jpg",
        text = "Special Offer",
        onClick = { handleClick() }
    )
)
OffersCarrousel(cards = cards)
```

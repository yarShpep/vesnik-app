<template>
  <v-container class="pa-4">
    <h1 class="text-h5 mb-4">🗺 География происшествий</h1>
    <div id="map" style="width: 100%; height: 600px;"></div>
  </v-container>
</template>

<script setup>
import { onMounted } from 'vue'

onMounted(async () => {
  await ymaps.ready(init)

  async function init() {
    const res = await fetch('/incidents_mock.json')
    const data = await res.json()

    const map = new ymaps.Map('map', {
      center: [55.75, 37.57],
      zoom: 7,
      controls: ['zoomControl']
    })

    data.forEach(item => {
      if (item.coordinates) {
        const placemark = new ymaps.Placemark(
          [item.coordinates.lat, item.coordinates.lng],
          {
            balloonContent: `
              <strong>${item.type}</strong><br/>
              ${item.date} – ${item.location}<br/>
              <a href="/incident/${item.id}">Подробнее</a>
            `
          },
          { preset: 'islands#redDotIcon' }
        )

        map.geoObjects.add(placemark)
      }
    })
  }
})
</script>
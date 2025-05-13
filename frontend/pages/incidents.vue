<template>
  <v-container>
    <h1 class="text-h5 mb-4">📋 Инциденты</h1>

    <v-data-table
      v-if="!isMobile"
      :headers="headers"
      :items="incidents"
      :items-per-page="5"
      class="elevation-1"
    >
      <template #item.date="{ item }">
        {{ item.date }} {{ item.time }}
      </template>
      <template #item.location="{ item }">
        {{ item.location }} (путь {{ item.track }}, {{ item.km_pk }})
      </template>
      <template #item.incident_type="{ item }">
        <strong>{{ item.incident_type }}</strong><br />
        <small>{{ item.description }}</small>
      </template>
      <template #item.region="{ item }">
        {{ item.region }}, {{ item.district }}, {{ item.city }}
      </template>
      <template #item.chairman="{ item }">
        {{ item.chairman }}
      </template>
    </v-data-table>

    <v-row v-else dense>
      <v-col cols="12" v-for="item in incidents" :key="item.date + item.time">
        <v-card class="mb-3" outlined>
          <v-card-title class="text-h6">{{ item.incident_type }}</v-card-title>
          <v-card-subtitle>{{ item.date }} {{ item.time }} — {{ item.location }}</v-card-subtitle>
          <v-card-text>
            <p><strong>Описание:</strong> {{ item.description }}</p>
            <p><strong>Путь:</strong> {{ item.track }}, {{ item.km_pk }}</p>
            <p><strong>Регион:</strong> {{ item.region }}, {{ item.district }}, {{ item.city }}</p>
            <p><strong>Председатель:</strong> {{ item.chairman }}</p>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
definePageMeta({ layout: 'default' })
import { ref, onMounted } from 'vue'
import { useDisplay } from 'vuetify'

const { smAndDown } = useDisplay()
const isMobile = smAndDown

const incidents = ref([])

const headers = [
  { title: 'Дата и время', value: 'date' },
  { title: 'Место', value: 'location' },
  { title: 'Тип происшествия', value: 'incident_type' },
  { title: 'Регион', value: 'region' },
  { title: 'Председатель', value: 'chairman' },
]

onMounted(async () => {
  const res = await fetch('/incidents_mock.json')
  incidents.value = await res.json()
})
</script>
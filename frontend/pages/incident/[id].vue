<template>
  <v-container class="pa-4">
    <v-btn icon @click="$router.back()" class="mb-4">
      <v-icon>mdi-arrow-left</v-icon>
    </v-btn>
    <v-card v-if="incident !== null && incident !== undefined">
      <v-card-title>{{ incident.type }}</v-card-title>
      <v-card-subtitle>{{ incident.date }} — {{ incident.location }}</v-card-subtitle>
      <v-card-text>
        <p><strong>Описание:</strong> {{ incident.description }}</p>
        <p><strong>Путь:</strong> {{ incident.track }}</p>
        <p><strong>Регион:</strong> {{ incident.region }}</p>
        <p><strong>Район:</strong> {{ incident.district }}</p>
        <p><strong>Город:</strong> {{ incident.city }}</p>
        <p><strong>Председатель:</strong> {{ incident.chairman }}</p>
      </v-card-text>
    </v-card>
    <v-alert type="error" v-else-if="incident === undefined">Происшествие не найдено.</v-alert>
  </v-container>
</template>

<script setup>
import { useRoute } from 'vue-router'
import { ref, onMounted } from 'vue'

const route = useRoute()
const incident = ref(null)

onMounted(async () => {
  const res = await fetch('/incidents_mock.json')
  const data = await res.json()
  incident.value = data.find(i => i.id === Number(route.params.id)) ?? undefined
})
</script>
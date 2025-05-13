<script setup>
definePageMeta({ layout: 'blank' })
</script>
<template>
  <v-container class="fill-height d-flex align-center justify-center pa-6">
    <div>
      <h1 class="text-h5 mb-6 text-center">🚦 Вестник происшествий</h1>
      <v-row dense>
        <v-col cols="12" sm="6">
          <v-btn block color="primary" to="/incidents">📋 Просмотр инцидентов</v-btn>
        </v-col>
        <v-col cols="12" sm="6">
          <v-btn block color="success" to="/report">➕ Сообщить о происшествии</v-btn>
        </v-col>
        <v-col cols="12" sm="6">
          <v-btn block color="secondary" to="/map">🗺 География происшествий</v-btn>
        </v-col>
        <v-col cols="12" sm="6">
          <v-btn block color="grey" to="/settings">⚙️ Настройки</v-btn>
        </v-col>
      </v-row>
    </div>
  </v-container>
</template>
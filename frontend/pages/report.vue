<template>
  <v-container class="pa-6">
    <h1 class="text-h5 mb-4">+ Сообщить о происшествии</h1>
    <v-form @submit.prevent="submitIncident" ref="form">
      <v-text-field v-model="incident.datetime" label="Дата и время" type="datetime-local" :rules="[v => !!v || 'Обязательное поле']" required />
      <v-text-field v-model="incident.location" label="Место (перегон или станция)" :rules="[v => !!v || 'Обязательное поле']" required />
      <v-text-field v-model="incident.track" label="Путь, км, ПК" :rules="[v => !!v || 'Обязательное поле']" required />
      <v-text-field v-model="incident.type" label="Тип происшествия" :rules="[v => !!v || 'Обязательное поле']" required />
      <v-textarea v-model="incident.description" label="Описание" :rules="[v => !!v || 'Обязательное поле']" rows="3" required />
      <v-text-field v-model="incident.region" label="Регион" :rules="[v => !!v || 'Обязательное поле']" required />
      <v-text-field v-model="incident.district" label="Район" :rules="[v => !!v || 'Обязательное поле']" required />
      <v-text-field v-model="incident.city" label="Город" :rules="[v => !!v || 'Обязательное поле']" required />
      <v-text-field v-model="incident.chairman" label="Председатель комиссии" :rules="[v => !!v || 'Обязательное поле']" required />
      <v-btn type="submit" color="primary" class="mt-4">Отправить</v-btn>
    </v-form>
  </v-container>
</template>
<script setup>
import { ref } from 'vue'

const incident = ref({
  datetime: '',
  location: '',
  track: '',
  type: '',
  description: '',
  region: '',
  district: '',
  city: '',
  chairman: ''
})

const submitIncident = async () => {
  try {
    // Получаем текущий список
    const res = await fetch('/incidents_mock.json')
    const list = await res.json()

    // Генерируем новый ID
    const newIncident = {
      id: list.length ? Math.max(...list.map(i => i.id)) + 1 : 1,
      ...incident.value
    }

    // Имитация отправки на сервер (локально — невозможно сохранить в JSON с клиента)
    console.log('Добавляем в mock:', newIncident)
    alert('Происшествие отправлено (эмуляция). Проверь console.log')
  } catch (e) {
    console.error('Ошибка при добавлении:', e)
    alert('Ошибка при добавлении в мок.')
  }
}
</script>
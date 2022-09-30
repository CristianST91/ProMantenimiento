const URL_API = "http://localhost:8080/userdata"

async function data_singup(evt) {
 // Indicar por medio del evento que no recargue página
 evt.preventDefault()

 const form = evt.target
 const user_ = {
   team: form.team.value,
   name: form.name.value,
   lastName: form.last_name.value,
   userName: form.user_name.value,
   password: form.password.value,
   teamAdmin: form.creat_team.checked
   
}

console.log("teamAdmin:");
console.log(user_.teamAdmin);
if (user_.teamAdmin==true){
  const resp = await fetch(`http://localhost:8080/userdata/team/adm/${user_.team}`)
  let adm = await resp.json()
if (adm.length == 0) {
  await create_user(user_)
}else{ 
  alert('The team already has an administrator')
}
  clear(form)
}
}



async function valueTeamAdmin(team) {
  const resp = await fetch(`http://localhost:8080/userdata/team/adm/${team}`)
  let dataUser = await resp.json()
  console.log(dataUser);
}

async function create_user(user_) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(user_)
  })

  const text = await resp.text()
  alert(text)
}

function clear (form) {
  form.team.value = ""
  form.name.value = ""
  form.last_name.value = ""
  form.user_name.value = ""
  form.password.value = ""
  form.creat_team.value = ""
}


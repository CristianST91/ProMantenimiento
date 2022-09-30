const URL_API2 = "http://localhost:8080/workorder"

//window.addEventListener('load', function() {
  //console.log('La página ha terminado de cargarse!!');

//});
async function data_work_order(evt) {
    evt.preventDefault()

    const form = evt.target
    const order_ = {
    team: window.localStorage.getItem('team'),
    dat: form.date.value,
    estimatedTime: form.estimated_time.value,
    activity: form.activity.value,
    userName: form.responsible.value,
    suggestions: form.suggestions.value,
    activityFinished: form.activity_finished.checked,
    }

    // console.log("----------tengo problemas?----------");
    
    if (window.localStorage.getItem("admin") == "true") {
      // console.log("admin ::> ");
      // console.log(order_);
      await create_order(order_)
      clear(form);
    } else {
      const selectOrder = document.getElementById('WON');
      order_.id = selectOrder.options[selectOrder.selectedIndex].value;
      const rT = form.real_time.value;
      if (rT == null) {
        order_.realTime = rT;
      }
      order_.notes = form.notes.value;
      // console.log("operario ::> ");
      // console.log(order_);
      await update_order(order_)
      if (document.getElementById('Check2').checked) {
        let closeOrder = document.getElementById("WON");
        closeOrder.remove(closeOrder.selectedIndex);
        document.getElementById('Check2').checked = false;
        changeBtnSubmit();
      }
      changeOrder();
    }
    
}

async function data_team() {
  const resp = await fetch(`http://localhost:8080/userdata/login/agend/${localStorage.team}`)
  let d_team = await resp.json();
  $selectUserTeam = document.getElementById('menu-list');
  d_team.forEach(element => {
    const option = document.createElement('option');
    option.value = element.userName;
    option.text = `${element.name} ${element.lastName}`;
    $selectUserTeam.appendChild(option);
  });
}

async function data_order(form, order_) {
  localStorage.removeItem('orders');
  const resp = await fetch(`${URL_API2}/order/${localStorage.userName}`)
  let orders = await resp.json();
  localStorage.setItem('orders', JSON.stringify(orders));

  let localOrders = await JSON.parse(localStorage.getItem('orders'));
  
  $selectUserOrder = document.getElementById('WON');
  if ($selectUserOrder.options.length == 0) {
    orders.forEach(element => {
      const option = document.createElement('option');
      option.value = element.id;
      option.text = element.id;
      $selectUserOrder.appendChild(option);
    });
  } else {
    if ($selectUserOrder.options.length < localOrders.length) {
      const option = document.createElement('option');
      option.value = orders.at(-1).id;
      option.text = orders.at(-1).id;
      $selectUserOrder.appendChild(option);
    }
  }
}

async function changeOrder() {
  await data_order();
  let selectBox = document.getElementById('WON');
  let optionSelect = selectBox.selectedIndex;
  if (optionSelect == -1) {
    setValuesOrder(0);
  } else {
    setValuesOrder(optionSelect);
  }
}

async function setValuesOrder(i) {
    // console.log("Llenando form con: ");
    document.getElementById('WON').selectedIndex = i;
    const orders = await JSON.parse(window.localStorage.getItem('orders'));
    let order = orders[i];
    // console.log(order);
    const act = document.getElementById('activ');
    act.value = order.activity;
    act.innerText = order.activity;
    document.getElementById('Suggestions-box').innerText = order.suggestions;
    const dat = document.getElementById('Estimated-time');
    dat.value = order.estimatedTime;
    dat.innerText = order.estimatedTime;
    document.getElementById('date-pick').value = order.dat
    document.getElementById('Notes-box').value = order.notes;
    document.getElementById('Real-time').value = order.realTime;
    await setBtnPage(i);

    console.log(document.getElementById('btn-back').value);;
    console.log(document.getElementById('btn-next').value);

    let responsible = document.getElementById('menu-list');
    const option = document.createElement('option');
      option.value = localStorage.getItem('userName');
      option.text = localStorage.getItem('userName');
      responsible.appendChild(option);
}

async function pageBack() {
  // evt.preventDefault();
  await setValuesOrder(document.getElementById('btn-back').value);
}

async function pageNext() {
  // evt.preventDefault();
  await setValuesOrder(document.getElementById('btn-next').value);
}

async function setBtnPage(indOrden) {
  console.log("seteando page");
  console.log(indOrden);
  let localOrders = await JSON.parse(localStorage.getItem('orders'));
  let lengthLocalOrders = localOrders.length - 1;
  // console.log(lengthLocalOrders);

  switch (indOrden) {
    case 0 || '0':
      console.log("opcion 0");
      document.getElementById('btn-back').disabled = true;
      document.getElementById('btn-back').value = parseInt(lengthLocalOrders);
      document.getElementById('btn-next').value = parseInt(indOrden) + 1;
      break;
    default:
      if (indOrden == lengthLocalOrders) {
        console.log("opcion final");
        document.getElementById('btn-next').disabled = true;
        document.getElementById('btn-back').value = parseInt(indOrden) - 1;
        document.getElementById('btn-next').value = parseInt(0);
      } else {
        console.log("otros casos");
        document.getElementById('btn-next').disabled = false;
        document.getElementById('btn-back').disabled = false;
        document.getElementById('btn-back').value = parseInt(indOrden) - 1;
        document.getElementById('btn-next').value = parseInt(indOrden) + 1;
      }
      break;
  }
}

async function create_order(order_) {
    // Enviar petición
    const resp = await fetch(URL_API2, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(order_)
    })
  
    const text = await resp.text()
    alert(text)
  }

  async function update_order(order_) {
    // Enviar petición
    const resp = await fetch(URL_API2, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(order_)
    })
  
    const text = await resp.text()
    alert(text)
  }
  
  function clear (form) {
    form.date.value = new Date().toLocaleDateString('en-CA');
    form.estimated_time.value = ""
    form.activity.value = ""
    form.suggestions.value = ""
  }

  async function data_login() {

    const resp = await fetch(`http://localhost:8080/userdata/login/${localStorage.userName}`)
    let dataUser = await resp.json()
    const user = {
        id: dataUser.id,
        admin: dataUser.teamAdmin
    }
}

function changeBtnSubmit() {
  if (document.getElementById('Check2').checked) {
    document.getElementById('btn-submit').innerText="Close";
  } else {
    document.getElementById('btn-submit').innerText="Save";
  }
  
}

function deleteStorage() {
  localStorage.clear();
}

//sdata_login()

if (window.localStorage.getItem('admin') == "true") {
  document.getElementById('Real-time').disabled=true;
  document.getElementById('Check2').disabled=true;
  document.getElementById('Notes-box').disabled=true;
  document.getElementById('WON').disabled=true;
  document.getElementById('btn-back').disabled=true;
  document.getElementById('btn-next').disabled=true;
  document.getElementById('date-pick').value = new Date().toLocaleDateString("en-CA");
  data_team()
} else {
  document.getElementById('Estimated-time').disabled=true;
  document.getElementById('menu-list').disabled=true;
  document.getElementById('activ').disabled=true;
  document.getElementById('Suggestions-box').disabled=true;
  document.getElementById('date-pick').disabled=true;
  changeOrder();
}
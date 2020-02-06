package set1

//import base64ToHex
//import hammingDistance
//import io.kotlintest.shouldBe
//import io.kotlintest.specs.StringSpec

//class Challenge6BreakRepeatingKeyXorTest : StringSpec({
//
//    "hamming 'this is a test' 'wokka wokka!!!'" {
//        val one = "this is a test"
//        val two = "wokka wokka!!!"
//
//        one.hammingDistance(two) shouldBe 37
//    }
//
//    "base64 to hex" {
//        val base64 = "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"
//
//        val expected = "1d421f4d0b0f021f4f134e3c1a69651f491c0e4e13010b074e1b01164536001e01496420541d1d4333534e6552060047541c0d454d07040c53123c0c1e08491a09114f144c211a472b00051d47591104090064260753003716060c1a17411d015254305f0020130a05474f124808454e653e160938450605081a46074f1f59787e6a62360c1d0f410d4806551a1b001d4274041e01491a091102527a7f4900483a001a13491a4f45480f1d0d53043a015219010b411306004c315f53621506070907540b17411416497933350b1b01050f46074f1d4e784e48275204070c4558480841004f205408740b1d194902000e165c00523069651f4902025400010b074e021053012610154d0207021f4f1b4e78306936520a010954060709534e021053083b100605490f0f104f3b003a5f472b1c4964334f540210531a4f051611740c064d0f020e0343524c3d4e002f0b490d084e170d15541d4f0e1c455e280b4d190112070a5553784e4f6206010b47531d0c0000170a051f0c3a425e4d2e0141220e1c493456416235064f472a7e3b084f011b0153423704071e0c4e151c0e06072b1a542a17491906595421455707030553073145782c070a411d095259374f00261d07491300130113454e0e491704390b5e4d1d06041a4f78773043003b1d1c4e1454151a0c4e494f080745390052673a0141130a0600375c4662550a0f125311482c000d000707173b095219010b41071b13473d1a2a161a0c1c020707480b4f4e0b0000163d0b554d08020d1b181744783069651f490709001911454f190149030d3516174d633a09114f15492a56492701491d06000d4811480b16491f0a220052000c4e001a0b5254305b54621b1a4e084b5462244e0a4f205306350b5209080002114f10452c4e4530521d06064e54090b594e040017453a42521d050f18546578732c5b4727525b4e4a0d543100414e1b0116453b0b174d100f465418134e365b002e1b1a1a024e541c0a0064261d5416740a140b490318540717413c1a532d52050b1300000000000c0a08074524091314491a0906000747301a2a111d49274743150645461b0102530c2045071d490f0f104f1f41335f002b06491d08551a0c454701000d536f654840405a4e381b4f5f0d78714e2d11024e084e541b0a4d0b4f1e1c0a3045782b061c4113001d447856552119454e2e0018010e454e021053173c1c1f081a4e00001d1d433155553152633d1250111a0641020e0f0104330c1e041a1a08170a0a50315b4c2b16060d0e4f011b452a27480453043a45170b0f0b02004f134e3c1a542a131d4e1e4f01480641004f0b1611746f3b4d0a0f0f541b134b3d1a416214051747471d1a09000f010d5308350e174d010b1354181754761a2a483b4e03474c1d0300003d0e04000a3a455f40493d00191c1d4e784e4f62360c020e4c1500452a3a070c010073165203064e0511010b49361d0c622b061b4743150645541c1649070a740d13030e4e6b361a0600215555651e054e0c45111845541c16001d4274111d4d0e0b1554020b002b4e592e1749642856111a4541000b491c1331175e4d191c00171b1b433d1a4d23190c1d4750111a03450d1b49792721115203061a411d095259374f073017490f474c1b0903451c4149796f0d0a074a050241130a06003655572a171b0b4b001a074550020e0a1649740b1d4d1d070c1143524e371a472b00051d472a27070a4e4e4244532a3c451f1449290e10435248375745201d0d174b000d0710001e1d06110436090b4d0c0f1554652150395d4827061d0747571d1c0d000f4f1a030a3b0b534d2a010c114f1d4e785b4e26521a0f1e001d1c440064653f3a357a45240c07070d180e52693b5f003b17194247591118490027480453063b081b034e4e09151d160034534b2752084e15481d060a00642607070a2c0c110c1d070f134f014f78434f37521a1a0647130d17000206021645354505040701417e3c1d00284f4e2901491d134f044811521706071445350b164d0e0713184f0154374a00210010070907546233410006051f04742c1108490712541c174c34534e6552080003000d0710001e0a0603093145131f0c4e0301161b4e7f1a2a6531081b1445541f0d594e1b0116453217170c021d41151d1700325543291b0749474c1d0300002d1d08091c74221e180c4e6b39000449361d00231c0d4e00521b07134900484907172d0c1c0a491a0e541c1b4e3f1a412e1d0709472a350409001a071b1c10330d5219010b41130717542c55002500060111491a4f455406061a530d3117174d1a010f134f786e374d003b1d1c49154554090841140a0d53072d4506050c4e373d3f5250374953275c49646d73000d155007014e53163b451a0c1b0a4118061945785b0005171b03064e5426045a074f632011351706010c0a4116165254305f0020131a0b14001c01115407014e5302260a07030d4e6b200717523d1d53621c064e13521d1815490048491c0b74081b030c42413d481f00324f5336520e0b13541d0642000a001e1d455e36020c1b0500190e06493b16000b55044e0f411a0f0c4e494f1d1a023c115201000504540e5246395441361b0a4e6d791b1d45541c0e19030030451f0849010f170a5241365e000b521d060855130011001a070807455e3c1d1849030813070600305b562752001a472a270745531a0a1953013b121c4d0800055403174e3c1a4d275210011252540d04524e654e4b5c740c1c4d04174100061f45791a792d07454e401944480c534e0210531c3104004349646b2d0007072a5f0035170805024e1d064200080e1a0749743c3d4c490f0f104f3b003b5b4e62060c020b001d1c452a37001c0145360a16144e1d41130a0654315407621a061a4b00070749001d00493a4537041c4d1a0304180352492c1a2a111d490a084e531c45420b4f04120174041c09490a0e1a4806003a5f0031130d4e6d07370910530b4f1d1b0074090b1f000d12540d174c3754476206064e2e6331444579011a4910043a45110c050241190a5264395e00482b061b4052114815491a0c011a0b7345134d0f0715584f014f7849542702490c06431f48044e0a4f0c1d012117174d632204004f06483d1a572b060a0647441b0b114f1c43493a0631495209064e151c0a524439544327521d014743011a0000643c0653063b08174d1c1e4117031d533d1a412c16490a084e531c45420b4f1a02103517174d63370e014f05413654416210081a134c114808454e424453243a1c0604040b4d540e1c592f5245301749646d791b1d455406001c140d20450605081a413d4f05412b1a572713024247621b11490017001c541731451608080a41031d1d4e3f1a2a111d490d084d11480a4e424f0c0500261c10020d1741150116002b534e25521d060e53541b0a4e094f637936351c5240444e31180e0b002c524136520f1b094b0d4808551d060a5336351c5e4d0e014103071b543d1a422d0b454e004f541f0d491a0a49110a2d451502496411180e0b002c524136520f1b094b0d4808551d060a53223b450505001a04540d1d59741a472d521e060e541148074f174349140a746f3e0c104e051b181c003954446210060100491148044e0a4f191f042d450605081a41121a1c4b211a4d3701000d47541d04090017001c53013d005c4d636431180e0b002c524136520f1b094b0d4808551d060a53263b08174d06004d542c1d4d3d1a4f2c5e4902025454050000060a0801455e351e0c104e151c0e06003e4f4e290b490312531d0b455706061d1645360a0b4d100114541c13597853546e521a0f1e001d1c452a3e03080a45200d13194908141a040b00354f532b11492f474c1d1c114c0b4f051c103000004d0701165465224c394300361a081a474601060e594e021c000c3749521a010715114f104f211a632d1f0c4e084e5848264f030a491c0b78453102040b411b01522a0856413b521d060654540e104e0516491e10270c114d63"
//        base64ToHex(base64) shouldBe expected
//    }
//
//    "transposed" {
//        val hex = "1d421f4d0b0f021f4f134e3c1a69651f491c0e4e13010b074e1b01164536001e01496420541d1d4333534e6552060047541c0d454d07040c53123c0c1e08491a09114f144c211a472b00051d47591104090064260753003716060c1a17411d015254305f0020130a05474f124808454e653e160938450605081a46074f1f59787e6a62360c1d0f410d4806551a1b001d4274041e01491a091102527a7f4900483a001a13491a4f45480f1d0d53043a015219010b411306004c315f53621506070907540b17411416497933350b1b01050f46074f1d4e784e48275204070c4558480841004f205408740b1d194902000e165c00523069651f4902025400010b074e021053012610154d0207021f4f1b4e78306936520a010954060709534e021053083b100605490f0f104f3b003a5f472b1c4964334f540210531a4f051611740c064d0f020e0343524c3d4e002f0b490d084e170d15541d4f0e1c455e280b4d190112070a5553784e4f6206010b47531d0c0000170a051f0c3a425e4d2e0141220e1c493456416235064f472a7e3b084f011b0153423704071e0c4e151c0e06072b1a542a17491906595421455707030553073145782c070a411d095259374f00261d07491300130113454e0e491704390b5e4d1d06041a4f78773043003b1d1c4e1454151a0c4e494f080745390052673a0141130a0600375c4662550a0f125311482c000d000707173b095219010b41071b13473d1a2a161a0c1c020707480b4f4e0b0000163d0b554d08020d1b181744783069651f490709001911454f190149030d3516174d633a09114f15492a56492701491d06000d4811480b16491f0a220052000c4e001a0b5254305b54621b1a4e084b5462244e0a4f205306350b5209080002114f10452c4e4530521d06064e54090b594e040017453a42521d050f18546578732c5b4727525b4e4a0d543100414e1b0116453b0b174d100f465418134e365b002e1b1a1a024e541c0a0064261d5416740a140b490318540717413c1a532d52050b1300000000000c0a08074524091314491a0906000747301a2a111d49274743150645461b0102530c2045071d490f0f104f1f41335f002b06491d08551a0c454701000d536f654840405a4e381b4f5f0d78714e2d11024e084e541b0a4d0b4f1e1c0a3045782b061c4113001d447856552119454e2e0018010e454e021053173c1c1f081a4e00001d1d433155553152633d1250111a0641020e0f0104330c1e041a1a08170a0a50315b4c2b16060d0e4f011b452a27480453043a45170b0f0b02004f134e3c1a542a131d4e1e4f01480641004f0b1611746f3b4d0a0f0f541b134b3d1a416214051747471d1a09000f010d5308350e174d010b1354181754761a2a483b4e03474c1d0300003d0e04000a3a455f40493d00191c1d4e784e4f62360c020e4c1500452a3a070c010073165203064e0511010b49361d0c622b061b4743150645541c1649070a740d13030e4e6b361a0600215555651e054e0c45111845541c16001d4274111d4d0e0b1554020b002b4e592e1749642856111a4541000b491c1331175e4d191c00171b1b433d1a4d23190c1d4750111a03450d1b49792721115203061a411d095259374f073017490f474c1b0903451c4149796f0d0a074a050241130a06003655572a171b0b4b001a074550020e0a1649740b1d4d1d070c1143524e371a472b00051d472a27070a4e4e4244532a3c451f1449290e10435248375745201d0d174b000d0710001e1d06110436090b4d0c0f1554652150395d4827061d0747571d1c0d000f4f1a030a3b0b534d2a010c114f1d4e785b4e26521a0f1e001d1c440064653f3a357a45240c07070d180e52693b5f003b17194247591118490027480453063b081b034e4e09151d160034534b2752084e15481d060a00642607070a2c0c110c1d070f134f014f78434f37521a1a0647130d17000206021645354505040701417e3c1d00284f4e2901491d134f044811521706071445350b164d0e0713184f0154374a00210010070907546233410006051f04742c1108490712541c174c34534e6552080003000d0710001e0a0603093145131f0c4e0301161b4e7f1a2a6531081b1445541f0d594e1b0116453217170c021d41151d1700325543291b0749474c1d0300002d1d08091c74221e180c4e6b39000449361d00231c0d4e00521b07134900484907172d0c1c0a491a0e541c1b4e3f1a412e1d0709472a350409001a071b1c10330d5219010b41130717542c55002500060111491a4f455406061a530d3117174d1a010f134f786e374d003b1d1c49154554090841140a0d53072d4506050c4e373d3f5250374953275c49646d73000d155007014e53163b451a0c1b0a4118061945785b0005171b03064e5426045a074f632011351706010c0a4116165254305f0020131a0b14001c01115407014e5302260a07030d4e6b200717523d1d53621c064e13521d1815490048491c0b74081b030c42413d481f00324f5336520e0b13541d0642000a001e1d455e36020c1b0500190e06493b16000b55044e0f411a0f0c4e494f1d1a023c115201000504540e5246395441361b0a4e6d791b1d45541c0e19030030451f0849010f170a5241365e000b521d060855130011001a070807455e3c1d1849030813070600305b562752001a472a270745531a0a1953013b121c4d0800055403174e3c1a4d275210011252540d04524e654e4b5c740c1c4d04174100061f45791a792d07454e401944480c534e0210531c3104004349646b2d0007072a5f0035170805024e1d064200080e1a0749743c3d4c490f0f104f3b003b5b4e62060c020b001d1c452a37001c0145360a16144e1d41130a0654315407621a061a4b00070749001d00493a4537041c4d1a0304180352492c1a2a111d490a084e531c45420b4f04120174041c09490a0e1a4806003a5f0031130d4e6d07370910530b4f1d1b0074090b1f000d12540d174c3754476206064e2e6331444579011a4910043a45110c050241190a5264395e00482b061b4052114815491a0c011a0b7345134d0f0715584f014f7849542702490c06431f48044e0a4f0c1d012117174d632204004f06483d1a572b060a0647441b0b114f1c43493a0631495209064e151c0a524439544327521d014743011a0000643c0653063b08174d1c1e4117031d533d1a412c16490a084e531c45420b4f1a02103517174d63370e014f05413654416210081a134c114808454e424453243a1c0604040b4d540e1c592f5245301749646d791b1d455406001c140d20450605081a413d4f05412b1a572713024247621b11490017001c541731451608080a41031d1d4e3f1a2a111d490d084d11480a4e424f0c0500261c10020d1741150116002b534e25521d060e53541b0a4e094f637936351c5240444e31180e0b002c524136520f1b094b0d4808551d060a5336351c5e4d0e014103071b543d1a422d0b454e004f541f0d491a0a49110a2d451502496411180e0b002c524136520f1b094b0d4808551d060a53223b450505001a04540d1d59741a472d521e060e541148074f174349140a746f3e0c104e051b181c003954446210060100491148044e0a4f191f042d450605081a41121a1c4b211a4d3701000d47541d04090017001c53013d005c4d636431180e0b002c524136520f1b094b0d4808551d060a53263b08174d06004d542c1d4d3d1a4f2c5e4902025454050000060a0801455e351e0c104e151c0e06003e4f4e290b490312531d0b455706061d1645360a0b4d100114541c13597853546e521a0f1e001d1c452a3e03080a45200d13194908141a040b00354f532b11492f474c1d1c114c0b4f051c103000004d0701165465224c394300361a081a474601060e594e021c000c3749521a010715114f104f211a632d1f0c4e084e5848264f030a491c0b78453102040b411b01522a0856413b521d060654540e104e0516491e10270c114d63"
//
//        val expected = listOf(
//            "1f0f4a1c1b16012d3e070d0219141b19045707040342450506186c48107e11793a1513094633090143150d4705005412106f00020002183a574036000f1450460d033048040509054203071a4109454e4b44050b295105380d5f1913070d0f30141e055a1652032d0b1b172a074b1b0d186901193731460d011f000b34186e265810400e0e1a1f6342444b4b16162a4c6d74044a5b000704003a47060c091f5b1541554e4d41044f0501182501403f40455d1601040a3c0e1a041f031a4f00144f1b444d010e03164e43343f394e32150113013c07044a1e3655454c144b0057214b17101d2c5a09221d5f1f13490a4a371b00091d121b1a0e5c19484d4d0d0905292d5c0a33014b5f146a4c0e301710061e165748040c074f42030645011829481736085a07530f281c3e0300091c0b15150e120d104b4d0d120b062d57092c144a19390c09472001441d1a184b45045d0e305c60511511180b460336065f1b110303673303194b1c3f46044a1e0509050a4f0104593a7d193f074e561107380736070311185717020e444705774452144b0a38460a7d000b021501044a370b00451a12110e4b140a4003675f09021766640931096e2b150a4d1f74464e0113061b041c310e0442410c08111d294c0a3731441a1843144e254d141d0835174247510a1e2d014f0c011b2d5b033248025b08031d473240194a191b561b0d5b0a094201430f151966480926124a0d19030d3e21094506165d1c04060e0e004b1d564a14186a0c38230a0f1f114c0d153007091c51101d4e23180b0a4204461c6",
//            "d4f4e6f030b404013665d0c3e114a0d19231c4130074539080f72110a140a0a0a1a4d010101660b193b074e575844090659420711121b36040e5b0f404c345f1c0e5d294d1e5b075e0b100f4d4e31073f020c161a1947512a090d134e0b14703c5a4832030c5f1c07094b3a024f065817350049054a49410d460000506a420032014e565b074d15275a310510535e1e0454030152100a49490019461227004f0d1503403f7e081d1a761d51400e5c0e1352114e0c1801264b2437004a1e06466d0b310710081157180c0d0a4d1e4605270605066646197346051e151d1d1229481143591b13100d710a09074b416a01062b070a7d014a0d2a434403350b00040c5157070f0b414e421d05350d5b3958243b45035e1a270c0f7f160005077d491f171547440004460c421468071633414a3b5d161c4d3307000c1c341342100d0a1e4d45071d011c264f0a37036d195803453f334d00461b19550e07250a14031c510a0b1d6658097b4d0f5b120d3c0e300f0e12505256494c0001010203074c48002027193c044a51546b0d467940431c0927550e48044f40460d204a41016607193c084a1a55420908300d031000575243411a02040b414c05050829480c27204a06114a491a331710061c1d1c0e4b0547414011422c0d1f397d0c261d4a121904484d3a484e001d16550309754e00420d563c011d254f192568025b0803450d771e4f4a301c52090a1d0a1b414d0000610c3f481a37044a5250013c1e3e42071500535e004e001800514d4f10062938464c32014a1e560c424101160e4013",
//            "4d0f394e0705195d5504475c0a4c4041060611502a484e36175e3d061d0102700348045110520714750f4e42084f0b4052695140250f40510903150f374303010f024f0e1d1e4103464d0a022114662b01374c0a1955034c49300305445d184b440909610045110019011d1c0840350b401715031d0f2946484a5c12524b2a55004542045442087c2b014137044b1a5a240b1733030005190711234b501f41060a40685858224b0e3813461e1e03180d356211041a1a5b0f475a0b4e53114f1f0f1d654a0d37045a331000400c7f0e0a00561b12134c040e105e015641050b295a093e174a1d131913493747054f05165a004214474e404742254e572d07163b045d071d430d0f7e1e103527125b49475b0e10421d060c1f083a4d02350e0f0d01040d1f30196104195755001e011e1e21145b4701122743287e494d1e13470a0c31070010511755094651414e0d144a050757297d0e3a084b1354401146301404420d27124210140240521d0046100b044f4d3204441e1503480a301800051916571a4a5b400e4214555c0119251840306d0f1512073c0f3e0b1a151e1652104d3743092d034f044e0a3d090d7b04440e35104c4a3000490b1f5147030a114248564b430905592d4a6637175a1a55421d0f31034544045c506946100a41534b0015011f19484c201503565a49103e210945065e0b1d4f0a1d0400420d562504142e58197e4b0411144f454a2d070011531b561b0d5b402d4e040a45150e295b0d3b04535f150a091433471c00075246160e07174f6f084a0501583d5e0921",
//            "2021c6941413e6443501503080f270700000a12500f0e180a49660d5b44495f404f0d32034f175719014f780c4128190c35040e56474e620652004f3a29421576034e0d154c2d1a7f07000c5e2c524a01571e075704530501572701493e0a731e1c47074a36024007510316170e0d42146f094106691a290809224a5b1e5443090f251609055558574d0e1b4f1e0b04061a481c25000823164a1715034d0f3048070f4a1f7d4e0b102c045928421c1011335a0f3e175b1d05434b0f341e41013a5312170f554b142b4d0e0540186c403c72414d2b1517036a250c14021e5b4e6640114c1349414b2101573949190703051b15060d0337070e4a191250101e164f60464d0f0b2c182a0c6f74086f121943030d3b05000a1d114717121501304114564b03072002057104435000034f067a0419051217594c0d041e090c0b481c4e1f27241b3203550115031d0f301501070c324763175b0a0507045f1701502a010e27405d1e154c0348330300150b161b41091c05064b6b5e054f560d50185d030b5a25031d033d12024c140f1d490e514407070d0e4c4f3b6c0c3c3613541a090a0d032a481201191651471b141d0c46217a0501594658117308490c144d1d0f37070f4656125703045b4e0346034f176e06684844360452141504454f27071017180d110d0206070042044f3c410c3f481a3e035a0e5d01421e21094502005d1d0407140e1040014f05011130541c3c68025b08030d4c3f4200051016490346164119521d234d4405294c053004431a0e004a1f23084f4b34125b0415174",
//            "1b13151e0e160413424c441c4911255467361d5f151866454f7a0f4502191248194f5a1b0c5504463b06182448007d0e00120b031d0f79090318091b5b6f1a14424c0b075f481258615c153e02463f78130e1e24462707771246401e1946470d154f4031076a580732074a1c0b000d0879491f4d131557101b120e045b044f0b021c3d494032047b5e50160d483012101619571d000c041a072d4541054f13295c0d604b011e5a4c4b40754e05171a0d513002030a0046012805021c2d480b7b044a1719030d187a47000a591d420c4a030e090b45560d0b016548107d040e14150c1d0b3d0715475612400c0c7d4200574a5e4b1c572527443f20471700110d153817101a5a1d5600443a07090741080849142846672103435a1706444c2e4342051e1141073014071c420d0a05031f684f41371505191019286030000947195b1e0a0a131b04001a56071f773c491d264d595405034c4670162a610c12500017560e025c1d480801123e560e5209465e1c4a110e310d141019125b051a0e130052475a02051c205d4e7c104a0e4c03036020020019391b520047061d040a470044145c194c047c0a0f1e304b0f1d370e4944151258121a13474f520f4f07640d2a4b19324c445100330d43314812101305521c0e5a0b09476b5005010b22611c36034a1d1a4512412e1e1e66541b561b0d5541044b044a05410c3f481a35145a5617446c0834004e14081c1704075d4400420d56280d1d2955085e4c0f0315060d1c741e1a05191b4b2c1b10416c0a41520905112c4809710b2656501e0d"
//        )
//
//        hex.transposed(5) shouldBe expected
//    }
//
//    "given example" {
//        val file = "/challenge-6-string.txt"
//
//        breakRepeatingKeyXor(file) shouldBe ""
//    }
//
//})